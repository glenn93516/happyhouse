<template>
  <div id="joinform container h-100">
    <h1 style="margin:30px;">회원가입페이지</h1>
    <hr />
    <b-card class="mt-3" header="회원가입">
      <div class="row h-100 justify-content-center align-items-center">
        <b-form
          class="joinform row text-center"
          @submit="onSubmit"
          @reset="onReset"
          v-if="show"
        >
          <b-form-group id="input-group-1" label="아이디" label-for="input-1">
            <b-form-input
              id="input-1"
              v-model="form.userid"
              type="email"
              required
              placeholder="Enter id"
            ></b-form-input> 
          </b-form-group>
          <b-form-group id="input-group-2" label="비밀번호" label-for="input-2">
            <b-form-input
              id="input-2"
              v-model="form.userpwd"
              required
              placeholder="Enter password"
            ></b-form-input>
          </b-form-group>
          <b-form-group
            id="input-group-3"
            label="비밀번호 재확인"
            label-for="input-3"
          >
            <b-form-input
              id="input-3"
              v-model="form.userpwd"
              required
              placeholder="Enter password again"
            ></b-form-input>
          </b-form-group>
          <b-form-group id="input-group-4" label="이메일" label-for="input-4">
            <b-form-input
              id="input-4"
              v-model="form.useremail"
              required
              placeholder="Enter email"
            ></b-form-input>
          </b-form-group>
          <b-form-group id="input-group-5" label="이름" label-for="input-5">
            <b-form-input
              id="input-5"
              v-model="form.username"
              required
              placeholder="Enter name"
            ></b-form-input>
          </b-form-group>
          <b-form-group id="input-group-5" label="휴대전화" label-for="input-6">
            <b-form-input
              id="input-6"
              v-model="form.userphone"
              required
              placeholder="Enter phonenumber"
            ></b-form-input>
          </b-form-group>
          <b-button type="submit" variant="primary">가입하기</b-button>
          <b-button type="reset" variant="danger">취소</b-button>
        </b-form>
      </div>
    </b-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        email: '',
        name: '',
        food: null,
        checked: [],
      },
      show: true,
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.form.email = '';
      this.form.name = '';
      this.form.food = null;
      this.form.checked = [];
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>

<style>
.joinform {
  text-align: center;
}
</style>
