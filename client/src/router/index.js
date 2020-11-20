import Vue from "vue";
import VueRouter from "vue-router";
import Qna from "../views/Qna.vue";
import QnaWrite from "../views/QnaWrite.vue";
import QnaDetail from "@/views/QnaDetail.vue";
import QnaList from "@/views/QnaList.vue";
Vue.use(VueRouter);

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
    component: QnaWrite
  },

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
