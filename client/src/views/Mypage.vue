<template>
    <div>
        <h1 class="mypagetitle">My Page</h1>
        <mypage-nav></mypage-nav>
        <router-view />
    </div>
</template>

<script>
import MypageNav from "@/components/MypageNav.vue";

export default {
    components: {
        MypageNav
    },
}

</script>

<style>
.mypagetitle{
    font-family: 'Nanum Gothic', sans-serif;
    font-weight: 900;
    margin: 30px;
}
</style>