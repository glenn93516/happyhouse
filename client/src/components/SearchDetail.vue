<template>
    <div>
        <b-container fluid class="my-2 d-flex justify-content-between">
            <h4><font-awesome-icon icon="undo" @click="showDealList" /> {{ propDeal.houseInfo.aptName.trim() }}</h4>
        </b-container>
        <b-card 
            no-body
            :img-src="require('../assets/home_floor_plan.png')"
            img-top
            class="m-3"
        >
            <template #header>
                <h4>{{ propDeal.houseInfo.aptName.trim() }}</h4>
            </template>
            
            <b-list-group flush>
                <b-list-group-item>
                    <b-row>
                        <b-col cols="4">매매가격 </b-col>
                        <b-col><b>{{propDeal.dealAmount}}</b></b-col>
                    </b-row>
                </b-list-group-item>
                <b-list-group-item>
                    <b-row>
                        <b-col cols="4">확인 날짜 </b-col>
                        <b-col><b>{{propDeal.dealYear}}-{{propDeal.dealMonth}}-{{propDeal.dealDay}}</b></b-col>
                    </b-row>
                </b-list-group-item>
                <b-list-group-item>
                    <b-row>
                        <b-col cols="4">면적 </b-col>
                        <b-col><b>{{propDeal.area}}m<sup>2</sup></b></b-col>
                    </b-row>
                </b-list-group-item>
                <b-list-group-item>
                    <b-row>
                        <b-col cols="4">층 </b-col>
                        <b-col><b>{{propDeal.floor}}</b></b-col>
                    </b-row>
                </b-list-group-item>
            </b-list-group>
        </b-card>
    </div>
</template>

<script>
export default {
    props: ['propDeal'],
    methods: {
        showDealList: function(){
            this.$emit('showDealList');
        }
    }
}
</script>

<style>

</style>