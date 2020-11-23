<template>
    <div class="container">
      <member-list></member-list>
  </div>
</template>

<script>
import MemberList from "@/views/MemberList.vue";

export default {
  components: {
    MemberList
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

#qnatable{
    font-family: 'Nanum Gothic', sans-serif;
    font-weight: 400;
}
</style>