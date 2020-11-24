<template>
  <div id="list">
    <hr />
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
        style="width: 70%; table-layout: fixed"
      >
        <thead>
          <tr class="table-primary">
            <th style="width:10%;">글번호</th>
            <th style="width:40%;">제목</th>
            <th style="width:15%;">등록일</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="board in titleCheck" :key="board.bnum">
            <td>{{ board.bnum }}</td>
            <td>
              <router-link :to="'/board/' + board.bnum">{{
                board.btitle
              }}</router-link>
            </td>
            <td>{{ board.bwritedate }}</td>
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

    <router-link to="/board/write"
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
          'http://localhost:8097/happyhouse/boards?' + this.curPage,
          this.searchCondition
        )
        .then((response) => {
          this.boards = response.data.noticeList;
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
        return board.btitle.includes(this.searchCondition);
      });
    },
  },
  created() {
    axios
      .get(
        'http://localhost:8097/happyhouse/boards?' + this.curpage,
        this.searchCondition
      )
      .then((response) => {
        this.totalPage = response.data.totalPage;
        this.boards = response.data.noticeList;
        this.curpage = response.data.curPage;
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
  font-weight: 600;
  margin: 30px;
}
#my-table {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 400;
}
.pagination {
  margin: 30px;
}
</style>
