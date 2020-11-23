import Vue from "vue";
import VueRouter from "vue-router";
import store from "@/store";
import axios from "axios";

// 메인페이지
import Main from "@/views/Main.vue";
import News from "@/views/News.vue";

// 검색 페이지
import Search from "@/views/Search.vue";

// Q & A
import Qna from "../views/Qna.vue";
import QnaWrite from "../views/QnaWrite.vue";
import QnaDetail from "@/views/QnaDetail.vue";
import QnaList from "@/views/QnaList.vue";

// 공지사항
import Boards from "../views/Boards.vue";
import BoardDetail from "../views/BoardDetail.vue";

// 로그인, 회원 가입
import Login from "@/views/Login.vue";
import Join from "@/views/Join.vue";

// 마이페이지
import Mypage from "@/views/Mypage.vue";
import MypageInfo from "@/views/MypageInfo.vue";
import MypageModify from "@/views/MypageModify.vue";
import MypageManagement from "@/views/MypageManagement.vue"; 
import Bookmark from "@/views/Bookmark.vue";

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
  // 메인 페이지
  {
    path: '/',
    name: 'Main',
    component: Main
  },
  // 즐겨찾기 페이지
  {
    path: '/bookmark',
    name: 'Bookmark',
    component: Bookmark
  },
  // 뉴스 게시판
  {
    path: '/news',
    name: 'News',
    component: News
  },
  // 검색 페이지
  {
    path: '/search',
    name: 'Search',
    component: Search,
  },
  // Qna 게시판
  {
    path: '/qna',
    name: 'Qna',
    component: Qna,
    children: [
      // QnA 목록
      {
        path: '',
        name: 'QnaList',
        component: QnaList
      },
      // QnA 작성
      {
        path: 'write',
        name: 'QnaWrite',
        component: QnaWrite,
        beforeEnter: requireAuth()
      },
      // QnA 상세보기
      {
        path: ':qnaId',
        name: 'QnaDetail',
        component: QnaDetail
      },
    ]
  },
  // 공지사항
  {
    path: '/boards',
    name: 'Boards',
    component: Boards,
  },
  // 공지사항 상세화면
  {
    path: '/boarddetail',
    name: 'BoardDetail',
    component: BoardDetail,
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
    component: Join
  },
  // 마이 페이지
  {
    path: '/mypage',
    name: 'Mypage',
    component: Mypage,
    children: [
      // 내 정보 보기
      {
        path: '',
        name: 'MypageInfo',
        component: MypageInfo
      },
      // 내 정보 수정
      {
        path: 'modify',
        name: 'MypageModify',
        component: MypageModify
      },
      // 회원 관리 (관리자 ID만 접근 가능)
      {
        path: 'manage',
        name: 'MypageManagement',
        component: MypageManagement
      }
    ]
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
