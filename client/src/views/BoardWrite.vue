<template>
  <div class="container">
    <div style="margin-top: 20px" class="d-flex justify-content-center">
      <table style="width:70%;">
        <tr>
          <td>제목</td>
          <td><b-form-input v-model="board.btitle" type="text" /></td>
        </tr>
        <tr>
          <td>내용</td>
          <td><b-form-input style="height:200px;" v-model="board.bcontent" type="text" /></td>
        </tr>
      </table>
    </div>
    <div class="d-flex justify-content-center" style="margin-top: 10px">
      <b-button variant="primary" @click="add">글쓰기</b-button>
      <b-button variant="danger" @click="cancel">취소</b-button>
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
      console.log(this.board);
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
    cancel(){
      
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
