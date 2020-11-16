<template>
  <div class="container">
    <div class="d-flex justify-content-center">
      <input
        v-on:keyup.enter="search"
        ref="searchBar"
        type="text"
        style="width: 300px; margin-right: 10px"
      />
      <b-button variant="primary" @click="search" style="margin-right: 10px">검색</b-button>
    </div>
    <div class="d-flex justify-content-center" style="margin-top: 20px">
      <table v-show="isSearch" style="width: 600px; table-layout: fixed">
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
          <tr v-for="board in titleCheck" :key="board.qnaId">
            <td>{{ board.qnaId }}</td>
            <td>{{ board.qnaTitle }}</td>
            <td>{{ board.qnaWriter }}</td>
            <td>{{ board.qnaWriteDate }}</td>
            <td>{{ board.qnaType }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      boards: [],
      searchCondition: '',
      isSearch: false,
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
        return board.qnaTitle.includes(this.searchCondition);
      });
    },
  },
  created() {
    axios
      .get(
        'http://localhost:8097/happyhouse/qna/list/1',
        this.searchCondition
      )
      .then((response) => {
        this.boards = response.data.qnaBoardList;
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
</style>
