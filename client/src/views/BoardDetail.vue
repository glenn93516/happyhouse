<template>
  <div class="container">
    <!-- 공지사항 디테일 -->
    <div style="margin-top: 20px" class="d-flex justify-content-center">
      <table style="width:70%;">
        <tr>
          <td>글번호</td>
          <td>
            <b-form-input v-model="board.bnum" type="text" readonly />
          </td>
        </tr>
        <tr>
          <td>제목</td>
          <td>
            <b-form-input v-if="isUpdate" v-model="board.btitle" type="text" />
            <b-form-input v-else v-model="board.btitle" type="text" readonly />
          </td>
        </tr>
        <tr>
          <td>등록일</td>
          <td>
            <b-form-input v-model="board.bwritedate" type="text" readonly />
          </td>
        </tr>
        <tr>
          <td>내용</td>
          <td>
            <b-form-input
              v-if="isUpdate"
              style="height:200px;"
              v-model="board.bcontent"
              type="text"
            />
            <b-form-input
              v-else
              style="height:200px;"
              v-model="board.bcontent"
              type="text"
              readonly
            />
          </td>
        </tr>
      </table>
    </div>
    <div>
      <router-link to="/board"
        ><b-button id="listBtn" style="margin:20px;"
          >목록</b-button
        ></router-link
      >
      <b-button @click="modifyBoard" id="modifyBtn" style="margin:20px;"
        >수정</b-button
      >
      <b-button
        v-if="!isUpdate"
        @click="deleteBoard"
        id="deleteBtn"
        style="margin:20px;"
        >삭제</b-button
      >
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      isUpdate: false,
      bnum: 0,
      board: {},
    };
  },
  created() {
    this.bnum = this.$route.params.bnum;
    this.isUpdate = false;
    axios
      .get('http://localhost:8097/happyhouse/boards/' + this.bnum)
      .then((response) => {
        this.board = response.data;
        console.log(this.board);
      });
  },
  methods: {
    modifyBoard: function() {
      if (!this.isUpdate) {
        this.isUpdate = true;
      } else {
        axios
          .put(
            'http://localhost:8097/happyhouse/boards/' + this.bnum,
            this.board
          )
          .then(({ data }) => {
            if (data == 'success') {
              alert('수정 성공');
            } else if (data == 'fail') {
              alert('수정에 실패했습니다.');
            }
            this.$router.push({
              path: '/board',
            });
          })
          .catch((error) => {
            alert('수정 중 오류 발생');
            console.log(error);
          });
      }
    },
    deleteBoard: function() {
      axios
        .delete('http://localhost:8097/happyhouse/boards/' + this.board.bnum)
        .then(({ data }) => {
          if (data == 'success') {
            alert('삭제 성공');
          } else if (data == 'fail') {
            alert('삭제 실패');
          }
          this.$router.push({
            path: '/board',
          });
        })
        .catch((error) => {
          alert('삭제 중 오류 발생');
          console.log(error);
        });
    },
  },
};
</script>

<style>
#listBtn {
  background-color: #8d9b46;
}
#modifyBtn {
  background-color: #889f00;
}
#deleteBtn {
  background-color: #68770e;
}
</style>
