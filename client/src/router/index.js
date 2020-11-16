import Vue from "vue";
import VueRouter from "vue-router";
import Search from "../views/Search.vue";
import Write from "../views/Write.vue"

Vue.use(VueRouter);

const routes = [
  {
    path: "/search",
    name: "Search",
    component: Search
  },
  {
    path: "/write",
    name: "Write",
    component: Write
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
