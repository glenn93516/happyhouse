<template>
  <div class="container">
    <qna-list></qna-list>
    <router-view/>
  </div>
</template>

<script>
import QnaList from "@/views/QnaList.vue";
export default {
  components : {
    QnaList
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
