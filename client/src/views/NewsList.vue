<template>
  <div id="newlist__container">
    <h1 class="newstitle">오늘의 뉴스</h1>
    <hr />
    <div style="margin:50px;">
      <div class="d-flex justify-content-center" style="margin-top: 20px">
        <b-table-simple class="table table-hover" responsive>
          <b-tr>
            <b-th>발간일</b-th>
            <b-th sticky-column style="width:50%">기사 제목</b-th>
            <!-- <b-th style="width:50%">내용</b-th> -->
            <b-th>원문 링크</b-th>
          </b-tr>
          <b-tr v-for="n in news" :key="n.originallink">
            <b-td>{{ n.pubDate | parseDate }}</b-td>
            <b-td v-html="n.title" sticky-column>{{ n.title }}</b-td>
            <!-- <b-td v-html="n.description">{{ n.description }}</b-td> -->
            <b-td><a :href="n.link">뉴스 보러가기</a></b-td>
          </b-tr>
        </b-table-simple>
      </div>
    </div>
  </div>
</template>

<script>
import moment from 'moment';
import axios from 'axios';

export default {
  data() {
    return {
      keyword: '부동산',
      news: [],
    };
  },
  created() {
    axios
      .get('http://localhost:8080/happyhouse/naver?keyword=' + this.keyword)
      .then(({ data }) => {
        this.news = data.items;
        // 여기서 items의 값을 바꿔치기 하는 처리해야함! router push말고
      });
  },
  filters: {
    // 날짜 2020-11-20 이런 형식으로 변경해주는 필터 추가
    parseDate: function(prevDate) {
      return moment(prevDate).format('YYYY-MM-DD');
    },
  },
};
</script>

<style>
#newslist__container {
  color: #707070;
  font-family: 'Nanum Gothic', sans-serif;
}
.newstitle {
  color: #2f2f2f;
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 900;
  margin: 30px;
}
</style>
