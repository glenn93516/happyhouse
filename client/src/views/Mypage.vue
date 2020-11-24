<template>
    <div id="mypage__container">
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
#mypage__container {
    font-family: 'Nanum Gothic', sans-serif;
    color: #707070;
}
</style>