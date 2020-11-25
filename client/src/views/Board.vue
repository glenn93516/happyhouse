<template>
  <div class="container">
    <h1 class="boardtitle">공지사항</h1>
    <router-view />
  </div>
</template>

<script>
export default {};
</script>

<style>
table,
td,
th {
  border: 1px solid #dddddd;
  text-align: center;
}
#writeBtn {
  background-color: #8d9b46;
  text-align: right;
}
.container {
  font-family: 'Nanum Gothic', sans-serif;
}
#title {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 900;
  margin: 30px;
}
.boardtitle {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
  margin: 30px;
  color: #2f2f2f;
}
</style>
