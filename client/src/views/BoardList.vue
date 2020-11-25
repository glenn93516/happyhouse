<template>
  <div class="list">
    <hr />
    <div class="d-flex justify-content-center">
      <input
        v-on:keyup.enter="search"
        ref="searchBar"
        type="text"
        style="width: 300px; margin-right: 10px"
        class="inputform"
      />
      <button @click="search" style="margin-right: 10px" class="searchBtn">
        검색
      </button>
    </div>
    <div class="d-flex justify-content-center" style="margin-top: 20px">
      <table
        class="table table-hover table-borderless border-0"
        id="my-table"
        :boards="boards"
        :per-page="perPage"
        :cur-page="curPage"
        v-show="isSearch"
        style="width: 70%; table-layout: fixed"
      >
        <thead>
          <tr class="tablehead">
            <th style="width:10%;">글번호</th>
            <th style="width:40%;">제목</th>
            <th style="width:15%;">등록일</th>
          </tr>
        </thead>
        <tbody>
          <tr
            style="cursor:pointer"
            v-for="(board, index) in titleCheck"
            :key="index"
            @click="moveDetail(board.bnum)"
          >
            <td>{{ (curPage - 1) * 10 + index + 1 }}</td>
            <td>{{ board.btitle }}</td>
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
      ><button id="writeBtn" style="margin:20px;">글쓰기</button></router-link
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
    moveDetail(bnum) {
      console.log(bnum);
      this.$router.push('/board/' + bnum);
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
  font-weight: 600;
}
button#writeBtn,
.searchBtn {
  width: 100px;
  height: 3em;
  background-color: #39bfbf;
  border: none;
  color: #fff;
  padding: 10px 0;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin: 4px;
  cursor: pointer;
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
}
.container {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
  margin: 30px;
}
#my-table {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 400;
  background-color: white;
}
.pagination {
  margin: 30px;
}
.tablehead {
  background-color: #39bfbf;
}
.list {
  background-color: white;
}
th {
  color: white;
}
#my-table {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 400;
  margin: 30px;
  color: #2f2f2f;
}
.inputform {
  width: 100%; /* 원하는 너비 설정 */
  height: 3em; /* 높이값 초기화 */
  line-height: normal; /* line-height 초기화 */
  padding: 0.8em 0.5em; /* 원하는 여백 설정, 상하단 여백으로 높이를 조절 */
  font-family: 'Nanum Gothic', sans-serif; /* 폰트 상속 */
  font-size: 14px;
  font-weight: 600;
  border: 1px solid #f6f6f6;
  background-color: #f6f6f6;
  border-radius: 0; /* iSO 둥근모서리 제거 */
  outline-style: none; /* 포커스시 발생하는 효과 제거를 원한다면 */
  -webkit-appearance: none; /* 브라우저별 기본 스타일링 제거 */
  -moz-appearance: none;
  appearance: none;
  margin-top: 0.4em;
}
</style>
