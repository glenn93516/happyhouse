<template>
  <div class="container">
    <hr />
    <!-- 공지사항 디테일 -->
    <div style="margin-top: 20px" class="d-flex justify-content-center">
      <table class="table border-0 " style="width:70%;">
        <tr>
          <th class="thth align-middle">글번호</th>
          <td class="tdtd">
            <input
              v-model="board.bnum"
              type="text"
              class="inputform"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th class="thth align-middle">제목</th>
          <td class="tdtd">
            <input
              v-if="isUpdate"
              v-model="board.btitle"
              class="inputform"
              type="text"
            />
            <input
              v-else
              v-model="board.btitle"
              type="text"
              class="inputform"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th class="thth align-middle">등록일</th>
          <td class="tdtd">
            <input
              v-model="board.bwritedate"
              type="text"
              class="inputform"
              readonly
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
              v-if="isUpdate"
              style="height:200px;"
              v-model="board.bcontent"
              type="text"
            />
            <input
              v-else
              style="height:200px;"
              v-model="board.bcontent"
              type="text"
              class="inputform"
              readonly
            />
          </td>
        </tr>
      </table>
    </div>
    <div>
      <router-link to="/board"
        ><button id="listBtn" style="margin:20px;">목록</button></router-link
      >
      <button @click="modifyBoard" id="modifyBtn" style="margin:20px;">
        수정
      </button>
      <button
        v-if="!isUpdate"
        @click="deleteBoard"
        id="deleteBtn"
        style="margin:20px;"
      >
        삭제
      </button>
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
#listBtn,
#modifyBtn,
#deleteBtn {
  background-color: #8d9b46;
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
input.inputform {
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
.thth {
  background-color: #39bfbf;
  color: white;
}
.tdtd {
  background-color: #f6f6f6;
  color: #2f2f2f;
}
</style>
