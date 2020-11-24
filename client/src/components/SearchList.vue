<template>
    <div>
        <!-- 정렬 등 옵션 선택 부분 -->
        <b-container fluid class="d-flex justify-content-end">
            <b-button-group class="align-items-center mr-md-3">
                <span class="mr-sm-2">정렬</span>
                <b-button @click="toggleShow('sort', 'dealAmount')" size="sm" title="가격으로 정렬"><font-awesome-icon icon="sort-numeric-up" /></b-button>
                <b-button @click="toggleShow('sort', 'aptName')" size="sm" title="아파트 이름으로 정렬"><font-awesome-icon icon="sort-alpha-up" /></b-button>
                <b-button @click="toggleShow('sort', 'area')" size="sm" title="면적 순으로 정렬"><font-awesome-icon icon="sort-amount-up" /></b-button>
            </b-button-group>
            <b-button-group class="align-items-center mr-md-1">
                <span class="mr-sm-2">view </span>
                <b-button @click="toggleShow('view', 'list')" size="sm"><font-awesome-icon icon="list" /></b-button>
                <b-button @click="toggleShow('view', 'thumbnail')" size="sm"><font-awesome-icon icon="border-all" /></b-button>
            </b-button-group>
        </b-container>

        <!-- list type view -->
        <b-container v-if="viewType === 'list'">
            <b-card no-body class="ml-5 my-1 border-0" v-for="deal in propDealList" :key="deal.dealId" @click="clickDeal(deal)">
                <b-row no-gutters>
                    <b-col md="3">
                        <b-card-img :src="require('../assets/ILgfyLB9u3IiZnS6GcW9t_SaeoeI.jpg')" height="100" class="rounded-2"></b-card-img>
                    </b-col>
                    <b-col class="pl-2 pt-2 text-left">
                        <b-card-text>
                            <b>{{deal.houseInfo.aptName.trim()}}</b><br>
                            <b>{{deal.dealAmount.trim()}}</b>만원<br>
                            {{deal.area}}m<sup>2</sup>
                        </b-card-text>
                    </b-col>
                </b-row>
            </b-card>
        </b-container>

        <!-- thumbnail type view -->
        <b-container  v-if="viewType === 'thumbnail'">
            <b-card-group deck v-for="(row, index) in thumbnailDeals" :key="index">
                <b-card 
                    overlay
                    v-for="deal in row" :key="deal.dealId"
                    text-variant="white"
                    :img-src="require('../assets/ILgfyLB9u3IiZnS6GcW9t_SaeoeI.jpg')"
                    img-height="100"
                    class="my-1 ml-1 border-0"
                    style="max-width: 10rem;"
                    @click="clickDeal(deal)"
                >
                </b-card>
            </b-card-group>
        </b-container>
    </div>
</template>

<script>
export default {
    props: ['propDealList'],
    data(){
        return {
            viewType: 'list',
            sortType: 'dealAmount',
        };
    },
    computed: {
        thumbnailDeals() {
            return this.propDealList.reduce((c, n, i) => {
                if(i % 4 == 0){
                    c.push([]);
                }
                c[c.length - 1].push(n);
                return c;
            }, []);
        }
    },
    methods: {
        toggleShow: function(type, data){
            switch(type){
                case 'view':
                    this.viewType = data;
                    break;
                case 'sort':
                    this.sortType = data;
                    this.sortData(this.sortType);
                    break;
            }
        },
        sortData: function(type){
            switch(type){
                // 가격 정렬
                case 'dealAmount':
                    this.propDealList.sort(function(a, b){
                        let a_dealAmount = parseInt(a.dealAmount.replace(',', ''), 10);
                        let b_dealAmount = parseInt(b.dealAmount.replace(',', ''), 10);
                        if(a_dealAmount > b_dealAmount){
                            return 1;
                        } else if(a_dealAmount < b_dealAmount){
                            return -1;
                        }
                        return 0;
                    })
                    break;
                // 이름으로 정렬
                case 'aptName':
                    this.propDealList.sort(function(a, b){
                        return a.houseInfo.aptName.localeCompare(b.houseInfo.aptName);
                    })
                    break;
                // 면적으로 정렬
                case 'area':
                    this.propDealList.sort(function(a, b){
                        let a_area = parseFloat(a.area.replace(',', ''));
                        let b_area = parseFloat(b.area.replace(',', ''));
                        if(a_area > b_area){
                            return 1;
                        } else if(a_area < b_area){
                            return -1;
                        }
                        return 0;
                    })
                    break;
            }
        },
        clickDeal: function(deal){
            this.$emit('showDetail', deal);
        }
    }
}
</script>

<style>
    .card-group .card {
        max-width: 25%;
    }
</style>