<template>
  <b-container style="width:300px;" class="container mt-5">
    <h1 class="titlejoin" style="margin:30px;">Sign Up</h1>
    <hr />
    <b-form class="joinform" @submit.prevent="onSubmit" @reset="onReset" v-if="show">
      <b-form-group>
        <b-form-input
          id="input-1"
          v-model="form.userid"
          type="text"
          required
          placeholder="ID"
        ></b-form-input>
      </b-form-group>

      <b-form-group>
        <b-form-input
          id="input-2"
          v-model="form.userpwd"
          type="text"
          required
          placeholder="PW"
        ></b-form-input>
      </b-form-group>

      <b-form-group>
        <b-form-input
          id="input-3"
          v-model="form.userpwdagain"
          type="text"
          required
          placeholder="PW CHECK"
        ></b-form-input>
      </b-form-group>

      <b-form-group>
        <b-form-input
          id="input-4"
          v-model="form.useremail"
          required
          type="email"
          placeholder="E-MAIL"
        ></b-form-input>
      </b-form-group>

      <b-form-group>
        <b-form-input
          id="input-5"
          v-model="form.username"
          required
          type="text"
          placeholder="NAME"
        ></b-form-input>
      </b-form-group>

      <b-form-group>
        <b-form-input
          id="input-6"
          v-model="form.userphone"
          required
          type="tel"
          placeholder="PHONE"
        ></b-form-input>
      </b-form-group>

      <button class="join-btn" type="submit">가입하기</button>
      <button class="reset-btn" type="reset">초기화</button>
    </b-form>
  </b-container>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      form: {
        userid: '',
        userpw: '',
        useremail: '',
        username: '',
        userphone: '',
      },
      show: true,
    };
  },
  methods: {
    onSubmit(event) {
      axios
        .post('http://localhost:8097/happyhouse/members/join', this.form)
        .then(({ data }) => {
          if (data == 'success') {
            alert('등록 성공');
          } else if (data == 'fail') {
            alert('등록 실패');
          }
          this.$router.push({
            // 완료후 홈으로
            path: '/',
          });
        })
        .catch((error) => {
          alert('등록 중 오류 발생');
          console.log(error);
        });
      alert(JSON.stringify(this.form));
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.form.userid = '';
      this.form.userpwd = '';
      this.form.userpwdagain = '';
      this.form.useremail = '';
      this.form.username = '';
      this.form.userphone = '';
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
  created() {
    
  },
};
</script>

<style>
.joinform {
  text-align: center;
}
.titlejoin {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
  color: #666666;
}
.join-btn,
.reset-btn {
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

#input-1,
#input-2,
#input-3,
#input-4,
#input-5,
#input-6 {
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
.container {
  align-self: center;
}
</style>
