<template>
  <div id="app" :class="currComp == 'Main' ? 'main' : 'notMain'">
    <homeheader :currComp="currComp"></homeheader>
    <router-view />
    <homefooter></homefooter>
  </div>
</template>

<style>
#app {
  font-family: 'Nanum Gothic', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

#app.main {
  background-color: #39bfbf;
}

#app.notMain {
  background-color: white;
}

#nav {
  padding: 30px;
}

/* #nav a.router-link-exact-active {
  color: #666666;
} */
</style>

<script>
import homefooter from '@/components/include/Footer.vue';
import homeheader from '@/components/include/Header.vue';
export default {
  components: {
    homefooter,
    homeheader,
  },
  computed: {
    currComp() {
      return this.$route.name; // 현재 보여주는 화면 뭔지. (메인화면이랑 다른 화면이랑 스타일 다르게)
    },
  },
};
</script>
