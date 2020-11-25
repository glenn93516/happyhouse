<template>
  <div class="overfolw-auto">
    <div class="d-flex justify-content-center">
      <input
        v-on:keyup.enter="search"
        ref="searchBar"
        type="text"
        style="width: 300px; margin-right: 10px"
      />
      <b-button variant="primary" @click="search" style="margin-right: 10px"
        >검색</b-button
      >
    </div>
    <div class="d-flex justify-content-center" style="margin-top: 20px">
      <table
        id="my-table"
        :boards="boards"
        :per-page="perPage"
        :cur-page="curPage"
        v-show="isSearch"
        style="width: 600px; table-layout: fixed"
      >
        <thead>
          <tr class="table-primary">
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>문의유형</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(board, index) in titleCheck" :key="index">
            <td>{{ (curPage - 1) * 10 + index + 1 }}</td>
            <td>
              <router-link :to="'/qna/' + board.qnaId">{{
                board.qnaTitle
              }}</router-link>
            </td>
            <td>{{ board.qnaWriter }}</td>
            <td>{{ board.qnaWriteDate }}</td>
            <td>{{ board.qnaType }}</td>
          </tr>
        </tbody>
      </table>
    </div>

    <b-pagination
      class="pagination"
      v-model="curPage"
      :total-rows="totalRows"
      :per-page="perPage"
      align="center"
      aria-controls="my-table"
      @change="pageChange"
    ></b-pagination>

    <router-link to="/qna/write"
      ><b-button id="writeBtn" style="margin:20px;"
        >글쓰기</b-button
      ></router-link
    >
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      // curPage: '',
      curPage: 1,
      perPage: 10,
      totalRows: 0,
      totalPage: 0,
      boards: [],
      searchCondition: '',
      isSearch: true,
    };
  },
  methods: {
    search() {
      this.searchCondition = this.$refs.searchBar.value;
      this.isSearch = true;
    },
    pageChange(page) {
      this.curPage = page;
      axios
        .get(
          'http://localhost:8097/happyhouse/qna/list/' + this.curPage,
          this.searchCondition
        )
        .then((response) => {
          this.boards = response.data.qnaBoardList;
          console.log(this.boards);
          console.log(this.curPage);
        })
        .catch()
        .finally();
    },
  },
  computed: {
    titleCheck() {
      return this.boards.filter((board) => {
        return board.qnaTitle.includes(this.searchCondition);
      });
    },
  },
  created() {
    // this.curPage = 1;
    axios
      .get(
        'http://localhost:8097/happyhouse/qna/list/' + this.curPage,
        this.searchCondition
      )
      .then((response) => {
        this.totalPage = response.data.totalPage;
        this.boards = response.data.qnaBoardList;
        this.curPage = response.data.curPage;
        this.totalRows = this.totalPage * this.boards.length;
      })
      .catch()
      .finally();
  },
};
</script>

<style>
table,
td,
th {
  border: 1px solid #dddddd;
  text-align: center;
}
#writeBtn {
  background-color: #8d9b46;
  text-align: right;
}
.container {
  font-family: 'Nanum Gothic', sans-serif;
}
/* #title{
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 900;
  margin: 30px;
} */
#my-table {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 400;
}
.pagination {
  margin: 30px;
}
</style>
