<template>
  <div id="mypageModify__container">
    <img
      src="./../assets/profile.png"
      width="300px;"
      style="margin-left:30px; margin-top:20px; margin-bottom:20px;"
    />
    <div
      class="d-flex justify-content-center border-0"
      style="margin-top: 20px; margin-bottom:20px;"
    >
      <table
        class="table border-0"
        style="width: 600px; table-layout: fixed"
        id="pagemodifytable"
      >
        <b-row id="modify--rowId">
          <b-col>ID</b-col>
          <b-col>
            <b-form-input
              id="modify--input-0"
              v-model="member.userid"
              readonly
              type="text"
              :placeholder="getUserid"
            ></b-form-input>
          </b-col>
        </b-row>
        <b-row id="modify--rowName">
          <b-col>NAME</b-col>
          <b-col>
            <b-form-input
              id="modify--input-1"
              v-model="member.username"
              type="text"
              :placeholder="getUsername"
            ></b-form-input>
          </b-col>
        </b-row>
        <b-row id="modify--rowEmail">
          <b-col>E-MAIL</b-col>
          <b-col>
            <b-form-input
              id="modify--input-2"
              v-model="member.useremail"
              type="text"
              :placeholder="getUseremail"
            ></b-form-input>
          </b-col>
        </b-row>
        <b-row id="modify--rowPhone">
          <b-col>PHONE</b-col>
          <b-col>
            <b-form-input
              id="modify--input-3"
              v-model="member.userphone"
              type="tel"
              :placeholder="getUserphone"
            ></b-form-input>
          </b-col>
        </b-row>
      </table>
    </div>
    <button @click="modifyInfo" class="modify-btn mb-4">수정</button>
  </div>
</template>

<script>
import axios from 'axios';
import { mapGetters } from 'vuex';
export default {
  computed: {
    ...mapGetters(['getUserid', 'getUsername', 'getUseremail', 'getUserphone']),
  },
  data() {
    return {
      member: {
        userid: this.$store.getters.getUserid,
        username: this.$store.getters.getUsername,
        useremail: this.$store.getters.getUseremail,
        userphone: this.$store.getters.getUserphone,
      },
    };
  },
  methods: {
    modifyInfo: function() {
      axios
        .put('http://localhost:8097/happyhouse/members', this.member)
        .then(({ data }) => {
          if (data == 'success') {
            alert('유저 정보 수정 완료');
          } else if (data == 'fail') {
            alert('유저 정보 수정 실패');
          }
          this.$router.push({
            path: '/',
          });
        })
        .catch((error) => {
          alert('ERR: 유저 정보 수정 중 오류 발생');
          console.log(error);
        });
    },
  },
};
</script>

<style>
#mypageModify__container {
  color: #707070;
  font-family: 'Nanum Gothic', sans-serif; /* 폰트 상속 */
  font-size: 20px;
  font-weight: 550;
}

#modify--rowId,
#modify--rowName,
#modify--rowEmail,
#modify--rowPhone {
  color: #707070;
  -webkit-appearance: none; /* 브라우저별 기본 스타일링 제거 */
  -moz-appearance: none;
  height: 3em; /* 높이값 초기화 */
  line-height: normal; /* line-height 초기화 */
  padding: 0.8em 0.5em; /* 원하는 여백 설정, 상하단 여백으로 높이를 조절 */
  background-color: #f6f6f6;
  border-radius: 0; /* iSO 둥근모서리 제거 */
}
#modify--input-0,
#modify--input-1,
#modify--input-2,
#modify--input-3 {
  width: 100%; /* 원하는 너비 설정 */
  height: 3em; /* 높이값 초기화 */
  line-height: normal; /* line-height 초기화 */
  padding: 0.8em 0.5em; /* 원하는 여백 설정, 상하단 여백으로 높이를 조절 */
  font-family: 'Nanum Gothic', sans-serif; /* 폰트 상속 */
  font-size: 14px;
  font-weight: 600;
  border: 1px solid white;
  background-color: white;
  border-radius: 0; /* iSO 둥근모서리 제거 */
  outline-style: none; /* 포커스시 발생하는 효과 제거를 원한다면 */
  -webkit-appearance: none; /* 브라우저별 기본 스타일링 제거 */
  -moz-appearance: none;
  appearance: none;
}
.modify-btn {
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
