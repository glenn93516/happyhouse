<template>
  <div id="list">
    <h1 class="boardtitle">공지사항</h1>
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
        v-show="isSearch"
        style="width: 70%; table-layout: fixed"
        id="boardtable"
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
      .get('http://localhost:8097/happyhouse/boards')
      .then((response) => {
        console.log(response);
        this.boards = response.data.noticeList;
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
.container,
.boardtitle {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
  margin: 30px;
}
#boardtable {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 400;
}
</style>
