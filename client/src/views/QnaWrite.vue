<template>
  <div class="container mt-5">
    <div style="margin-top: 20px" class="d-flex justify-content-center">
      <table class="table border-0 " style="width:70%;">
        <tr>
          <th class="thth align-middle">제목</th>
          <td class="tdtd">
            <input
              v-model="board.qnaTitle"
              class="inputform"
              type="text"
            />
          </td>
        </tr>
        <tr>
          <th class="thth align-middle">문의유형</th>
          <td class="tdtd">
            <b-form-select class="inputform" v-model="board.qnaType">
              <option value="1">회원정보</option>
              <option value="2">매물등록</option>
              <option value="3">허위매물신고</option>
              <option value="4">기타</option>
            </b-form-select>
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
              v-model="board.qnaContent"
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
      <router-link to="/qna"
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
      //   qna_id: '',
      //   qna_writedate: '',
        qnaTitle: '',
        qnaWriter: this.$store.getters.getUserid,
        qnaContent: '',
        qnaType: '',
      }
    };
  },
  methods: {
    add() {
      console.log(this.board);
      axios
        .post('http://localhost:8097/happyhouse/qna/add', this.board)
        .then((response) => {
          if (response.data) alert('글이 등록되었습니다.');
          this.$router.push({
            path: '/qna'
          })
        })
        .catch((error) => {
          alert('글 작성 중 오류가 발생하였습니다.');
          console.log(error);
        })
        .finally();
    }
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
