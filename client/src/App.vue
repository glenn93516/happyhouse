<template>
  <div id="app">
    <homeheader></homeheader>
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
  /* color: #FFFFFF; */
  background-color: #39BFBF;
  /* background-color: #39BFBF; */
}

#nav {
  padding: 30px;
}


/* #nav a.router-link-exact-active {
  color: #666666;
} */
</style>

<script>
import homefooter from "@/components/include/Footer.vue";
import homeheader from "@/components/include/Header.vue";
export default {
  components : {
    homefooter, homeheader,
  }
}
</script>
