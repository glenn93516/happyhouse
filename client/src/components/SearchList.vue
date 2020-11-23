<template>
    <div>
        <!-- 정렬 등 옵션 선택 부분 -->
        <b-container fluid class="d-flex justify-content-end">
            <b-button-group class="align-items-center mr-md-3">
                <span class="mr-sm-2">정렬</span>
                <b-button size="sm" title="가격으로 정렬"><font-awesome-icon icon="sort-numeric-up" /></b-button>
                <b-button size="sm" title="아파트 이름으로 정렬"><font-awesome-icon icon="sort-alpha-up" /></b-button>
                <b-button size="sm" title="면적 순으로 정렬"><font-awesome-icon icon="sort-amount-up" /></b-button>
            </b-button-group>
            <b-button-group class="align-items-center mr-md-1">
                <span class="mr-sm-2">view </span>
                <b-button size="sm"><font-awesome-icon icon="list" /></b-button>
                <b-button size="sm"><font-awesome-icon icon="border-all" /></b-button>
            </b-button-group>
        </b-container>
    </div>
</template>

<script>
export default {

}
</script>

<style>

</style>