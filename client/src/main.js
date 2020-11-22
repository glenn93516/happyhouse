import Vue from 'vue';
import App from './App.vue';
import router from './router';
import VueSession from 'vue-session';
import BootstrapVue from 'bootstrap-vue';
import store from "./store";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import "@/fontAwesomeIcon.js";

// 새로고침 할 때 마다 실행될것
const localAccessToken = () => {
  const authtoken = localStorage.getItem("auth-token");
  if (!authtoken)
      return;
  axios.defaults.headers.common["auth-token"] = authtoken;
  store.state.isAuthenticated = true;
  // TODO : Backend server에 auth-token으로 유저 정보 받아와서 저장해야함
}

localAccessToken();

Vue.config.productionTip = false;
Vue.use(VueSession, sessionOptions);
Vue.use(BootstrapVue);

var sessionOptions = {
  persist: true
};


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
