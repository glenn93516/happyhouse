<template>
  <div class="container">
    <div style="margin-top: 20px" class="d-flex justify-content-center">
      <table style="width:70%;">
        <tr>
          <td>제목</td>
          <td><b-form-input v-model="qna_title" type="text" /></td>
        </tr>
        <tr>
          <td>문의유형</td>
          <td>
            <b-form-select v-model="qna_type">
              <option>회원정보</option>
              <option>매물등록</option>
              <option>허위매물신고</option>
              <option>기타</option>
            </b-form-select>
          </td>
        </tr>
        <tr>
          <td>내용</td>
          <td><b-form-input style="height:200px;" v-model="qna_content" type="text" /></td>
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
    //   qna_id: '',
    //   qna_writedate: '',
      qna_title: '',
      qna_writer: '',
      qna_content: '',
      qna_type: '',
    };
  },
  created(){
    let loginSession = this.$session.get('loginInfo');       // 세션 정보 와야함. -> 컨트롤쪽에서 온다.
    this.qna_writer = loginSession.get("userid");
  },
  methods: {
    add() {
      let board = {
        //qna_id: this.qna_id,
        //qna_writer: this.qna_writer,
        //qna_writedate: this.qna_writedate,
        qna_title: this.qna_title,
        qna_content: this.qna_content,
        qna_type: this.qna_type,
      };
      console.log(board);
      axios
        .post('http://localhost:8097/happyhouse/qna/add', board)
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
