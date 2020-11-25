<template>
  <div class="container">
    <!-- Qna 질문 -->
    <div style="margin-top: 20px" class="d-flex justify-content-center">
      <table class="table border-0" style="width:70%;">
        <tr>
          <th class="thth align-middle">글번호</th>
          <td class="tdtd">
            <input
              class="inputform"
              v-model="board.qnaId"
              type="text"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th class="thth align-middle">제목</th>
          <td class="tdtd">
            <input
              class="inputform"
              v-if="isUpdate"
              v-model="board.qnaTitle"
              type="text"
            />
            <input
              class="inputform"
              v-else
              v-model="board.qnaTitle"
              type="text"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th class="thth align-middle">작성자</th>
          <td class="tdtd">
            <input
              class="inputform"
              v-model="board.qnaWriter"
              type="text"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th class="thth align-middle">등록일</th>
          <td class="tdtd">
            <input
              class="inputform"
              v-model="board.qnaWriteDate"
              type="text"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th class="thth align-middle">문의유형</th>
          <td class="tdtd" v-if="isUpdate">
            <b-form-select v-model="board.qnaType">
              <option value="1">회원정보</option>
              <option value="2">매물등록</option>
              <option value="3">허위매물신고</option>
              <option value="4">기타</option>
            </b-form-select>
          </td>
          <td class="tdtd" v-else>
            <input
              class="inputform"
              v-if="board.qnaType == 1"
              value="회원정보"
              type="text"
              readonly
            />
            <input
              class="inputform"
              v-else-if="board.qnaType == 2"
              value="매물등록"
              type="text"
              readonly
            />
            <input
              class="inputform"
              v-else-if="board.qnaType == 3"
              value="허위매물신고"
              type="text"
              readonly
            />
            <input
              class="inputform"
              v-else-if="board.qnaType == 4"
              value="기타"
              type="text"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th class="thth align-middle">내용</th>
          <td class="tdtd">
            <input
              class="inputform"
              v-if="isUpdate"
              style="height:200px;"
              v-model="board.qnaContent"
              type="text"
            />
            <input
              class="inputform"
              v-else
              style="height:200px;"
              v-model="board.qnaContent"
              type="text"
              readonly
            />
          </td>
        </tr>
      </table>
    </div>
    <div>
      <router-link to="/qna"
        ><button id="listBtn" style="margin:20px;">목록</button></router-link
      >
      <button @click="modifyQna" id="modifyBtn" style="margin:20px;">
        수정
      </button>
      <button
        v-if="!isUpdate"
        @click="deleteQna"
        id="deleteBtn"
        style="margin:20px;"
      >
        삭제
      </button>
    </div>

    <!-- Qna 답변 -->
    <qna-answer v-bind:qnaId="qnaId"></qna-answer>
  </div>
</template>

<script>
import QnaAnswer from '@/components/QnaAnswer.vue';

import axios from 'axios';

export default {
  components: {
    QnaAnswer,
  },
  data() {
    return {
      isUpdate: false,
      qnaId: 0,
      board: {},
    };
  },
  created() {
    this.qnaId = this.$route.params.qnaId;
    this.isUpdate = false;
    axios
      .get('http://localhost:8097/happyhouse/qna/read/' + this.qnaId)
      .then((response) => {
        this.board = response.data;
      });
  },
  methods: {
    modifyQna: function() {
      if (!this.isUpdate) {
        this.isUpdate = true;
      } else {
        axios
          .put('http://localhost:8097/happyhouse/qna/modify', this.board)
          .then(({ data }) => {
            if (data == 'success') {
              alert('수정 성공');
            } else if (data == 'fail') {
              alert('수정에 실패했습니다.');
            }
            this.$router.push({
              path: '/qna',
            });
          })
          .catch((error) => {
            alert('수정 중 오류 발생');
            console.log(error);
          });
      }
    },
    deleteQna: function() {
      axios
        .delete(
          'http://localhost:8097/happyhouse/qna/delete/' + this.board.qnaId
        )
        .then(({ data }) => {
          if (data == 'success') {
            alert('삭제 성공');
          } else if (data == 'fail') {
            alert('삭제 실패');
          }
          this.$router.push({
            path: '/qna',
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
  width: 100px;
  height: 3em;
  background-color: #33b3b6;
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
</style>
