<template>
  <div id="header">
      <b-row fluid no-gutters class="h-100">
        <b-col cols="9" class="d-flex justify-content-end align-items-center">
          <b-nav id="menu" class="h-100">
            <b-nav-item 
              v-for="menu in menus" :key="menu.path"
              :class="'h-100 d-flex align-items-center ' + (selected == menu.name ? 'active' : '')"
              @click="clickMenu(menu.name)"
              @mouseover="mouseIn(menu.name)"
            >
              <router-link v-if="menu.name != 'main'" :to="menu.path">{{ menu.title }}</router-link>
              <router-link v-else :to="menu.path"><b-img :src="require('../../assets/uh_logo.svg')" width="40" height="40"></b-img></router-link>
            </b-nav-item>
          </b-nav>
        </b-col>

        <b-col class="d-flex justify-content-end align-items-center">
        <b-nav id="loginbar">
          <b-nav-item v-if="isAuthenticated" @click="logout">로그아웃</b-nav-item>
          <b-nav-item v-else
            ><router-link to="/login">로그인</router-link></b-nav-item
          >
          <b-nav-item><router-link to="/join">회원가입</router-link></b-nav-item>
        </b-nav>
        </b-col>
      </b-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters['getIsAuthenticated'],
    isAuthenticated() {
      return this.$store.state.isAuthenticated;
    }
  },
  data(){
    return {
      selected: '',
      menus: [
        {name: 'board', path : '/board', title:'공지사항'},
        {name: 'search', path : '/search', title:'매물 검색'},
        {name: 'newlist', path : '/newslist', title:'오늘의 뉴스'},
        {name: 'main', path : '/'},
        {name: 'bookmark', path : '/bookmark', title:'즐겨찾기'},
        {name: 'qna', path : '/qna', title:'QnA'},
        {name: 'mypage', path : '/mypage', title:'마이페이지'}
      ]
    };
  },
  methods: {
      logout: function(){
        this.$store.dispatch('LOGOUT');
        this.$router.push({
            path: '/'
        });
      },
      clickMenu : function(name){
        this.selected = name;
      },
      mouseIn : function(name){
        this.selected = name;
      },
  }
}
</script>

<style scoped>
#header {
  background-color : transparent;
  height: 20vh;
}

.nav-item a{
  color: #fbf6f0;
  text-decoration: none;
  font-weight: 800;
}
.nav-item.active, .nav-item.active a{
  color: #707070;
  transition: all 500ms ease-in-out;
}

#loginbar {
  font-family: 'Nanum Gothic', sans-serif;
}
</style>