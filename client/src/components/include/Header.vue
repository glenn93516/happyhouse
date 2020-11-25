<template>
  <div id="header">
    <b-nav fluid no-gutters class="h-100 d-flex justify-content-center">
      <b-navbar id="menu" class="h-100" align="center">
        <b-nav-item
          v-for="menu in menus"
          :key="menu.path"
          :class="
            'h-100 d-flex align-items-center ' +
              (selected == menu.name ? 'active ' : ' ') +
              isMain
          "
          @click="clickMenu(menu.name)"
          @mouseover="mouseIn(menu.name)"
        >
          <router-link v-if="menu.name != 'main'" :to="menu.path">{{
            menu.title
          }}</router-link>
          <router-link v-else :to="menu.path"
            ><b-img
              :src="require('../../assets/uh_logo.svg')"
              width="40"
              height="40"
            ></b-img
          ></router-link>
        </b-nav-item>
      </b-navbar>

      <b-navbar id="loginbar h-100" align="right">
        <b-nav-item
          v-if="isAuthenticated"
          :class="
            'h-100 d-flex align-items-center ' +
              (selected == 'logout' ? 'active ' : ' ') +
              isMain
          "
          @click="logout"
          @mouseover="mouseIn('logout')"
          >로그아웃</b-nav-item
        >
        <b-nav-item
          v-else
          :class="
            'h-100 d-flex align-items-center ' +
              (selected == 'login' ? 'active ' : ' ') +
              isMain
          "
          @click="clickMenu('login')"
          @mouseover="mouseIn('login')"
          ><router-link to="/login">로그인</router-link></b-nav-item
        >
        <b-nav-item
          :class="
            'h-100 d-flex align-items-center ' +
              (selected == 'join' ? 'active ' : ' ') +
              isMain
          "
          @click="clickMenu('join')"
          @mouseover="mouseIn('join')"
          ><router-link to="/join">회원가입</router-link></b-nav-item
        >
      </b-navbar>
    </b-nav>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  props: ['currComp'],
  computed: {
    ...mapGetters['getIsAuthenticated'],
    isAuthenticated() {
      return this.$store.state.isAuthenticated;
    },
    isMain() {
      return this.currComp == 'Main' ? 'main' : 'notMain';
    },
  },
  data() {
    return {
      selected: '',
      menus: [
        { name: 'board', path: '/board', title: '공지사항' },
        { name: 'search', path: '/search', title: '매물 검색' },
        { name: 'newlist', path: '/newslist', title: '오늘의 뉴스' },
        { name: 'bookmark', path: '/bookmark', title: '즐겨찾기' },
        { name: 'main', path: '/' },
        { name: 'qna', path: '/qna', title: 'QnA' },
        { name: 'mypage', path: '/mypage', title: '마이페이지' },
      ],
    };
  },
  methods: {
    logout: function() {
      this.selected = 'logout';
      this.$store.dispatch('LOGOUT');
      this.$router.push({
        path: '/',
      });
    },
    clickMenu: function(name) {
      this.selected = name;
    },
    mouseIn: function(name) {
      this.selected = name;
    },
  },
};
</script>

<style scoped>
#header {
  background-color: transparent;
  height: 20vh;
}

.nav-item.main a {
  color: #fbf6f0;
  text-decoration: none;
  font-weight: 800;
}
.nav-item.active.main,
.nav-item.active.main a {
  color: #707070;
  transition: all 500ms ease-in-out;
}

.nav-item.notMain a {
  color: #707070;
  text-decoration: none;
  font-weight: 800;
}
.nav-item.notMain.active,
.nav-item.notMain.active a {
  color: white;
  background-color: #39bfbf;
  transition: all 500ms ease-in-out;
}

#loginbar {
  font-family: 'Nanum Gothic', sans-serif;
}
</style>
