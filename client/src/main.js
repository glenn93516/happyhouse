import Vue from 'vue';
import App from './App.vue';
import router from './router';
import VueSession from 'vue-session';
import BootstrapVue from 'bootstrap-vue';
import store from "./store";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';


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
