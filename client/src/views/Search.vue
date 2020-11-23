<template>
    <div>
        <search-nav></search-nav>
        <search-list v-if="showList"></search-list>
        <search-detail v-else></search-detail>
        <google-map></google-map>
    </div>
</template>

<script>
import SearchNav from "@/components/SearchNav.vue";
import SearchList from "@/components/SearchList.vue";
import SearchDetail from "@/components/SearchDetail.vue";
import GoogleMap from "@/components/GoogleMap.vue";

export default {
    components: {
        SearchNav,
        SearchList,
        SearchDetail,
        GoogleMap
    },
    data(){
        return {
            showList: true
        };
    }
}
</script>

<style>

</style>