<template>
  <div class="container">
    <qna-nav></qna-nav>
    <router-view/>
  </div>
</template>

<script>
import QnaNav from "@/components/QnaNav.vue";

export default {
  components : {
    QnaNav
  }
}
</script>

<style>
table,
td,
th {
  border: 1px solid #dddddd;
  text-align: center;
}
#writeBtn{
  background-color: #8d9b46;
  text-align: right;
}
.container{
  font-family: 'Nanum Gothic', sans-serif;
}
#title{
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 900;
  margin: 30px;
}
</style>
