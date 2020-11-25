<template>
  <div class="container mt-5">
    <div style="margin-top: 20px" class="d-flex justify-content-center">
      <table class="table border-0 " style="width:70%;">
        <tr>
          <th class="thth align-middle">제목</th>
          <td class="tdtd">
            <input
              v-model="board.btitle"
              class="inputform"
              type="text"
            />
          </td>
        </tr>
        <tr>
          <th class="thth align-middle" align="center">
            내용
          </th>
          <td class="tdtd">
            <input
              class="inputform"
              style="height:200px;"
              v-model="board.bcontent"
              type="text"
            />
          </td>
        </tr>
      </table>
    </div>
    <div>
      <button @click="add" id="addBtn" style="margin:20px;">
        글쓰기
      </button>
      <router-link to="/board"
        ><button id="listBtn" style="margin:20px;">취소</button></router-link
      >
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      board : {
        btitle: '',
        bwriter: '관리자',
        bwritedate: '',
        bcontent: '',
      }
    };
  },
  methods: {
    add() {
      axios
        .post('http://localhost:8097/happyhouse/boards', this.board)
        .then((response) => {
          if (response.data) alert('글이 등록되었습니다.');
          this.$router.push({
            path: '/board'
          })
        })
        .catch((error) => {
          alert('글 작성 중 오류가 발생하였습니다.');
          console.log(error);
        })
        .finally();
    },
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
#addBtn {
  width: 100px;
  height: 3em;
  background-color: #33b3b6;
  border: none;
  color: #fff;
  padding: 10px 0;
  text-align: center;
  text-decoration: none;
  /* display: inline-block; */
  font-size: 15px;
  margin: 4px;
  cursor: pointer;
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
}
</style>
