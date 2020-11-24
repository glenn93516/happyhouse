<template>
    <div>
        <!-- 검색 창 -->
        <b-form inline class="d-flex justify-content-center my-2" @submit.prevent="onSubmit">
            <b-form-select class="mx-2" v-model="searchConditions.sido" @change="getGugun">
                <option selected disabled :value="null">시/도</option>
                <option v-for="sido in sidos" :key="sido.sidoCode" :value="sido.sidoCode">{{ sido.sidoName }}</option>
            </b-form-select>
            <b-form-select class="mx-2" v-model="searchConditions.gugun" @change="getDong">
                <option selected disabled :value="null">구/군</option>
                <option v-for="gugun in guguns" :key="gugun.gugunCode" :value="gugun.gugunCode">{{ gugun.gugunName }}</option>
            </b-form-select>
            <b-form-select class="mx-2" v-model="searchConditions.dong">
                <option selected disabled :value="null">동</option>
                <option v-for="dong in dongs" :key="dong.dongCode" :value="dong.dongCode">{{ dong.dongName }}</option>
            </b-form-select>
            <b-form-input class="w-25" v-model="searchConditions.aptName" placeholder="아파트 이름을 입력해주세요"></b-form-input>
            <b-button type="submit"><font-awesome-icon icon="search" /></b-button>
        </b-form>

        <b-container fluid></b-container>
        <b-row>
            <b-col cols="5">
                <!-- 매물 목록 -->
                <search-list v-if="showList" v-on:showDetail="showDetail" v-bind:propDealList="dealList"></search-list>
                <!-- 상세보기 -->
                <search-detail v-else v-on:showDealList="showDealList" v-bind:propDeal="dealDetail"></search-detail>
            </b-col>
            <b-col cols="7">
                <!-- 구글 지도 -->
                <google-map v-bind:propDealList="dealList"></google-map>
            </b-col>
        </b-row>
    </div>
</template>

<script>
import SearchList from "@/components/SearchList.vue";
import SearchDetail from "@/components/SearchDetail.vue";
import GoogleMap from "@/components/GoogleMap.vue";

import axios from "axios";

export default {
    components: {
        SearchList,
        SearchDetail,
        GoogleMap
    },
    created: function(){
        axios.get('http://localhost:8097/happyhouse/map/sido')
            .then(({data}) => {
                this.sidos = data;
            })
            .catch((error) => {
                alert("시/도 정보를 가져오는 중 에러 발생");
                console.log(error);
            })
    },
    data(){
        return {
            showList: true,
            sidos: [],
            guguns: [],
            dongs: [],
            searchConditions: {
                sido: '',
                gugun: '',
                dong: '',
                aptName: ''
            },
            dealList : [],
            dealDetail: {}
        };
    },
    methods: {
        getGugun: function(){
            axios.get('http://localhost:8097/happyhouse/map/gugun/' + this.searchConditions.sido)
            .then(({data}) => {
                this.guguns = data;
            })
            .catch((error) => {
                alert("구/군 정보를 가져오는 중 에러 발생");
                console.log(error);
            })
        },
        getDong: function(){
            axios.get('http://localhost:8097/happyhouse/map/dong/' + this.searchConditions.gugun)
            .then(({data}) => {
                this.dongs = data;
            })
            .catch((error) => {
                alert("동 정보를 가져오는 중 에러 발생");
                console.log(error);
            })
        },
        onSubmit: function(){
            axios.get('http://localhost:8097/happyhouse/dealLists', {
                    params: this.searchConditions
                })
                .then(({data}) => {
                    this.dealList = data;
                })
                .catch((error) => {
                    alert("검색 결과 가져오는 중 에러 발생");
                    console.log(error);
                })
        },
        showDetail: function(deal){
            this.dealDetail = deal;
            this.showList = false;

            // TODO : 구글 지도에 선택한 거래 정보 위치 넘기는 과정 추가해야함
        },
        showDealList: function(){
            this.showList = true;
        }

    }
}
</script>

<style>

</style>