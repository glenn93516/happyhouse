<template>
  <div class="container">
    <div style="margin-top: 20px" class="d-flex justify-content-center">
      <table style="width:70%;">
        <tr>
          <td>제목</td>
          <td><b-form-input v-model="board.qnaTitle" type="text" /></td>
        </tr>
        <tr>
          <td>문의유형</td>
          <td>
            <b-form-select v-model="board.qnaType">
              <option value="1">회원정보</option>
              <option value="2">매물등록</option>
              <option value="3">허위매물신고</option>
              <option value="4">기타</option>
            </b-form-select>
          </td>
        </tr>
        <tr>
          <td>내용</td>
          <td><b-form-input style="height:200px;" v-model="board.qnaContent" type="text" /></td>
        </tr>
      </table>
    </div>
    <div class="d-flex justify-content-center" style="margin-top: 10px">
      <b-button variant="primary" @click="add">글쓰기</b-button>
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
        qnaWriter: 'ssafy',
        qnaContent: '',
        qnaType: '',
      }
    };
  },
  created(){
    // let loginSession = this.$session.get('loginInfo');       // 세션 정보 와야함. -> 컨트롤쪽에서 온다.
    // this.qna_writer = loginSession.get("userid");
  },
  methods: {
    add() {
      console.log(this.board);
      axios
        .post('http://localhost:8097/happyhouse/qna/add', this.board)
        .then((response) => {
          if (response.data) alert('글이 등록되었습니다.');
          else alert('오류가 발생하였습니다.');
          location.href = 'search';
        })
        .catch()
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
</style>
