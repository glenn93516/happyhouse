<template>
  <div id="qnalist--container" class="overfolw-auto">
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
      <b-table
        :items="boards"
        :fields="fields"
        :per-page="perPage"
        :cur-page="curPage"
        style="width: 600px; table-layout: fixed"
      >

      </b-table>
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
      ><b-button id="writeBtn"
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
      fields: [
              {key: 'qnaId', label:'글번호'}, 
              {key: 'qnaTitle', label: '제목', sortable: true}, 
              {key: 'qnaWriter', label: '작성자', sortable: true}, 
              {key: 'qnaWriteDate', label: '등록일'}, 
              {key: 'qnaType', label: '문의유형'},
      ],
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

<style scoped>
#qnalist--container{
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
  color: #707070;
}

table,
td,
th {
  border: 1px solid #dddddd;
  text-align: center;
}
button#writeBtn {
  width: 100px;
  height: 3em;
  background-color: #33b3b6;
  border: none;
  border-radius: 0;
  color: #fff;
  padding: 10px 0;
  text-align: center;
  text-decoration: none;
  font-size: 15px;
  margin: 4px;
  cursor: pointer;
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
}

.container {
  font-family: 'Nanum Gothic', sans-serif;
}

#my-table {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 400;
}
.pagination {
  margin: 30px;
}

</style>
