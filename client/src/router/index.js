import Vue from "vue";
import VueRouter from "vue-router";
import Qna from "../views/Qna.vue";
import QnaWrite from "../views/QnaWrite.vue";
import QnaDetail from "@/views/QnaDetail.vue";
import QnaList from "@/views/QnaList.vue";
import Login from "@/views/Login.vue";
import store from "@/store";
import axios from "axios";


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
  {
    path: "/qna",
    name: "Qna",
    component: Qna
  },
  {
    path: "/qnalist",
    name: "QnaList",
    component: QnaList
  },
  {
    path: "/qna/:qnaId",
    // path: "/qnadetail",
    component : QnaDetail
  },
  {
    path: "/qnawrite",
    name: "QnaWrite",
    component: QnaWrite,
    beforeEnter: requireAuth()
  },
  {
    path: "/login",
    name: "Login",
    component: Login
  },
  {
    path: "/login/:nextRoute",
    name: "LoginNextRoute",
    component: Login
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
