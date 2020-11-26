<template>
  <b-container style="width:300px; height: 400px;" class="mt-5">
    <b-form @submit.prevent="login">
      <b-form-group id="input-group-id" label="" label-for="input-id">
        <b-form-input
          id="input-id"
          v-model="user.userid"
          type="text"
          required
          placeholder="ID"
        >
        </b-form-input>
      </b-form-group>
      <b-form-group id="input-group-pw" label="" label-for="input-pw">
        <b-form-input
          id="input-pw"
          v-model="user.userpw"
          type="password"
          required
          :state="pwState"
          aria-describedby="input-pw-feedback"
          placeholder="PW"
        >
        </b-form-input>
        <b-form-invalid-feedback id="input-pw-feedback">
          비밀번호는 5자 이상 입력해주세요
        </b-form-invalid-feedback>
      </b-form-group>
      <button class="login-btn" type="submit">Login</button>
      <router-link to="/join"
        ><button class="findpw-btn" type="submit">Join</button></router-link
      >
    </b-form>
  </b-container>
</template>

<script>
import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

export default {
  data: function() {
    return {
      user: {
        userid: '',
        userpw: '',
      },
      message: '',
    };
  },
  computed: {
    nextRoute() {
      return this.$route.params.nextRoute ? this.$route.params.nextRoute : '';
    },
    pwState() {
      return this.user.userpw.length >= 5 ? true : false;
    },
  },
  methods: {
    login: function() {
      // LOGIN 액션 실행
      // 서버와 통신(axios)을 해 토큰값을 얻어야 하므로 Actions를 호출.
      this.$store
        .dispatch('LOGIN', this.user)
        .then(() => this.$router.replace(`/${this.nextRoute}`))
        .catch(({ message }) => (this.msg = message));
    },
  },
};
</script>

<style>
/* .login-btn {
  background-color: #d4dca3;
  color: #2c3e50;
} */

.findpw-btn,
.login-btn {
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

#input-pw,
#input-id {
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
}
</style>
