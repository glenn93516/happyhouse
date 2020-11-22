<template>
    <b-container style="width:300px; height: 400px;" class="mt-5">
        <b-form @submit.prevent="login">
            <b-form-group
                id="input-group-id"
                label="아이디"
                label-for="input-id">
                <b-form-input
                    id="input-id"
                    v-model="user.userid"
                    type="text"
                    required
                    placeholder="아이디를 입력해주세요">
                </b-form-input>
            </b-form-group>
            <b-form-group
                id="input-group-pw"
                label="비밀번호"
                label-for="input-pw">
                <b-form-input
                    id="input-pw"
                    v-model="user.userpw"
                    type="password"
                    required
                    :state="pwState"
                    aria-describedby="input-pw-feedback"
                    placeholder="비밀번호를 입력하세요">
                </b-form-input>
                <b-form-invalid-feedback id="input-pw-feedback">
                    비밀번호는 5자 이상 입력해주세요
                </b-form-invalid-feedback>
            </b-form-group>
            <b-button no-border class="login-btn" type="submit">로그인</b-button>
        </b-form>
    </b-container>
</template>

<script>
import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

export default {
    data: function() {
        return {
            user: {
                userid: "",
                userpw: ""
            },
            message: ""
        };
    },
    computed: {
        nextRoute() {
            return this.$route.params.nextRoute ? this.$route.params.nextRoute : "";
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
                .dispatch("LOGIN", this.user)
                .then(() => this.$router.replace(`/${this.nextRoute}`))
                .catch(({ message }) => (this.msg = message));
        },
    }
};
</script>

<style>
    .login-btn {
        background-color: #d4dca3;
        color : #2c3e50;
    }
</style>