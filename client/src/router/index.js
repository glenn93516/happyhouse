import Vue from "vue";
import VueRouter from "vue-router";
import store from "@/store";
import axios from "axios";


// 메인페이지
import Main from "@/views/Main.vue";

// 검색 페이지
import Search from "@/views/Search.vue";

// 즐겨찾기
import Bookmark from "@/views/Bookmark.vue";
import BookmarkList from "@/views/BookmarkList.vue";

// Q & A
import Qna from "../views/Qna.vue";
import QnaWrite from "../views/QnaWrite.vue";
import QnaDetail from "@/views/QnaDetail.vue";
import QnaList from "@/views/QnaList.vue";

// 공지사항
import Board from "../views/Board.vue";
import BoardDetail from "../views/BoardDetail.vue";
import BoardList from "../views/BoardList.vue";
import BoardWrite from "../views/BoardWrite.vue";

// 뉴스
import NewsList from "../views/NewsList.vue";

// 로그인, 회원 가입
import Login from "@/views/Login.vue";
import Join from "@/views/Join.vue";

// 마이페이지
import Mypage from "@/views/Mypage.vue";
import MypageInfo from "@/views/MypageInfo.vue";
import MypageModify from "@/views/MypageModify.vue";
import MypageManagement from "@/views/MypageManagement.vue"; 

Vue.use(VueRouter);

const requireAuth = () => (to, from, next) => {
  const nextRoute = to.path;
  
  let token = axios.defaults.headers.common["auth-token"];
  
  if (token != null && token.length) {
    axios.get('http://localhost:8097/happyhouse/members/info')
      .then(({ data }) => {
        if (data.exp > (Date.now() / 1000)) {
          // auth-token 유효한 경우
          store.commit("setAuth", token);
          return next();
        } else {
          next("/login");
        }
      })
  } else {
    next("/login");
  }
}

const routes = [
  // 메인 페이지
  {
    path: '/',
    name: 'Main',
    component: Main
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
  // 즐겨찾기(북마크)
  {
    path: '/bookmark',
    name: 'Bookmark',
    component: Bookmark,
    beforeEnter: requireAuth(),
    children: [
      {
        path: '',
        name: 'BookmarkList',
        component: BookmarkList
      }
    ]
  },
  // 공지사항
  {
    path: '/board',
    name: 'Board',
    component: Board,
    children: [
      // 공지사항 목록
      {
        path: '',
        name: 'BoardList',
        component: BoardList
      },
      // 공지사항 작성
      {
        path: 'write',
        name: 'BoardWrite',
        component: BoardWrite,
        beforeEnter: requireAuth()      // 관리자일때에만 작성가능
      },
      // 공지사항 상세보기
      {
        path: ':bnum',
        name: 'BoardDetail',
        component: BoardDetail
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
    component: Join
  },
  // 뉴스 리스트
  {
    path: '/newslist',
    name: 'NewsList',
    component: NewsList,
  },
  // 마이 페이지
  {
    path: '/mypage',
    name: 'Mypage',
    component: Mypage,
    beforeEnter: requireAuth(),
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
