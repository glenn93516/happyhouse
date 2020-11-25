<template>
  <div>
    <b-navbar
      class="mypagenav justify-content-center mt-3"
      toggleable="lg"
      type="dark"
    >
      <b-navbar-nav class="navout">
        <b-nav-item
          v-for="menu in menus"
          :key="menu.name"
          :class="selected == menu.name ? 'active' : ''"
          @click="onClick(menu.name)"
        >
          <router-link class="navLink" :to="menu.path">{{
            menu.title
          }}</router-link>
        </b-nav-item>
        <b-nav-item
          v-if="getRole == 1"
          :class="selected == 'mypageMgmt' ? 'active' : ''"
          @click="onClick('mypageMgmt')"
        >
          <router-link class="navLink" to="/mypage/manage"
            >회원 관리</router-link
          >
        </b-nav-item>
      </b-navbar-nav>
    </b-navbar>
    <hr />
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['getRole']),
  },
  data() {
    return {
      selected: 'mypage',
      menus: [
        { name: 'mypage', path: '/mypage', title: '내 정보' },
        { name: 'mypageModify', path: '/mypage/modify', title: '정보 수정' },
      ],
    };
  },
  methods: {
    onClick: function(selected) {
      this.selected = selected;
    },
  },
};
</script>

<style>
.nav-item .navLink {
  color: #707070;
  font-family: 'Nanum Gothic', sans-serif;
  text-decoration: none;
  font-size: 18px;
  font-weight: 500;
}
.nav-item .navLink:hover {
  font-weight: 700;
}
.nav-item.active .navLink {
  font-weight: 700;
}
</style>
