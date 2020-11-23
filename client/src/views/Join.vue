<template>
  <b-container class="fill-height">
    <h1 class="titlejoin" style="margin:30px;">회원가입페이지</h1>
    <hr />
    <div class="row h-100 justify-content-center align-items-center">
      <b-form
        style="width:40%;"
        class="joinform row text-center"
        @submit="onSubmit"
        @reset="onReset"
        v-if="show"
      >
        <b-row>
          <b-col>
            <b-form-group
              id="input-group"
              label="아이디"
              label-for="input-1"
            ></b-form-group>
          </b-col>
          <b-col>
            <b-form-input
              id="input-1"
              v-model="form.userid"
              type="text"
              required
              placeholder="Enter id"
            ></b-form-input>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form-group
              id="input-group-2"
              label="비밀번호"
              label-for="input-2"
            ></b-form-group>
          </b-col>
          <b-col>
            <b-form-input
              id="input-2"
              v-model="form.userpwd"
              type="text"
              required
              placeholder="Enter password"
            ></b-form-input>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form-group
              id="input-group-3"
              label="비밀번호 재확인"
              label-for="input-3"
            ></b-form-group>
          </b-col>
          <b-col>
            <b-form-input
              id="input-3"
              v-model="form.userpwdagain"
              type="text"
              required
              placeholder="Enter password again"
            ></b-form-input>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form-group
              id="input-group-4"
              label="이메일"
              label-for="input-4"
            ></b-form-group>
          </b-col>
          <b-col>
            <b-form-input
              id="input-4"
              v-model="form.useremail"
              required
              type="email"
              placeholder="Enter email"
            ></b-form-input>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form-group
              id="input-group-5"
              label="이름"
              label-for="input-5"
            ></b-form-group>
          </b-col>
          <b-col>
            <b-form-input
              id="input-5"
              v-model="form.username"
              required
              type="text"
              placeholder="Enter name"
            ></b-form-input>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form-group
              id="input-group-5"
              label="휴대전화"
              label-for="input-6"
            ></b-form-group>
          </b-col>
          <b-col>
            <b-form-input
              id="input-6"
              v-model="form.userphone"
              required
              type="phonenumber"
              placeholder="Enter phonenumber"
            ></b-form-input>
          </b-col>
        </b-row>
        <b-button type="submit" variant="primary">가입하기</b-button>
        <b-button type="reset" variant="danger">초기화</b-button>
      </b-form>
    </div>
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
      event.preventDefault();
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
}
</style>
