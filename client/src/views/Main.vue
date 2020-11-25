<template>
  <div id="home" class="d-flex justify-content-center align-items-center">
    <span class="logotitle">UNHAPPY, <br />BUT HAPPY</span>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style>
#home {
  background: url('../assets/building.png') no-repeat center;
  background-size: 50% 50%;
  font-family: 'Nanum Gothic', sans-serif;
  font-size: 120px;
  font-weight: 1000;
  height: 80vh;
  /* color: #aff1dd; */
  color: white;
  transition: all 500ms ease-in-out;
}
.logotitle {
  line-height: 100%;
}
</style>
