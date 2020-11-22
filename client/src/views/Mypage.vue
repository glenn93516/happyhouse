<template>
    <div>
        <mypage-nav></mypage-nav>
        <router-view />
    </div>
</template>

<script>
import MypageNav from "@/components/MypageNav.vue";

export default {
    components: {
        MypageNav
    }
}
</script>

<style>

</style>