import Vue from "vue";
import VueRouter from "vue-router";
import store from "@/store";
import axios from "axios";

import Qna from "../views/Qna.vue";
import QnaWrite from "../views/QnaWrite.vue";
import QnaDetail from "@/views/QnaDetail.vue";
import QnaList from "@/views/QnaList.vue";
import Login from "@/views/Login.vue";
import Join from "@/views/Join.vue";

Vue.use(VueRouter);

const requireAuth = () => (to, from, next) => {
  const nextRoute = to.path;
  let token = axios.defaults.headers.common["auth-token"];

  // TODO : axios로 Spring boot 서버에 요청 보내서 현재 토큰 유효한지 확인하는 작업 필요
  console.log("requireAuth() called");
  if (token != undefined && token.length) {
    store.commit("setAuth", token);
    return next();
  } else {
    next("/login" + nextRoute);
  } 
}
const routes = [
  // Qna 게시판
  {
    path: '/qna',
    name: 'Qna',
    component: Qna,
    children: [
      {
        path: '',
        name: 'QnaList',
        component: QnaList
      },
      {
        path: 'write',
        name: 'QnaWrite',
        component: QnaWrite,
        beforeEnter: requireAuth()
      },
      {
        path: ':qnaId',
        name: 'QnaDetail',
        component: QnaDetail
      },
    ]
  },
  // 로그인
  {
    path: "/login",
    name: "Login",
    component: Login
  },
  {
    path: "/login/:nextRoute",
    name: "LoginNextRoute",
    component: Login
  },
  // 회원가입
  {
    path: '/join',
    name: 'Join',
    Component: Join
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
