<template>
  <div id="newlist__container">
    <h1 class="newstitle">오늘의 뉴스</h1>
    <hr />
    <div style="margin:50px;">
      <table
        class="table table-hover"
        style="width:70%; margin:auto; text-align:center;"
      >
        <thead>
          <tr>
            <th>originallink(제공언론사)</th>
            <th>title</th>
            <th>pubDate</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>news1</td>
            <td>
              <router-link to="/newslist/news"
                >'아파트 환상 버리면' 진선미, 호텔업계와 간담회... 내용은
                '함구'</router-link
              >
            </td>
            <td>2020.11.23. 18:24</td>
          </tr>
          <tr>
            <td>한국경제</td>
            <td>
              <router-link to="/newslist/news"
                >치솟은 김포 집값에... 남모르게 웃음 짓는 곳이?
                [집코노미]</router-link
              >
            </td>
            <td>2020.11.23. 10:09</td>
          </tr>
          <tr>
            <td>한국경제</td>
            <td>
              <router-link to="/newslist/news"
                >지방도 '패닉바잉' 시작됐나... 30대 주택구매 '큰
                손'</router-link
              >
            </td>
            <td>2020.11.23. 08:48</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      tmpToken: '',
      newsList: [],
    };
  },
  created() {
    this.tmpToken = axios.defaults.headers.common['auth-token'];
    delete axios.defaults.headers.common['auth-token'];
    axios
      .get('https://openapi.naver.com/v1/search/news.json', {
        params: {
          query: '부동산',
          display: 5,
        },
        headers: {
          'X-Naver-Client-Id': 'qvRxDFfzMefBdQSpHtqK',
          'X-Naver-Client-Secret': 'kuIdFXfcC9',
          'Access-Control-Allow-Origin': 'http://localhost:8080/',
          'Access-Control-Allow-Credentials': 'true',
        },
      })
      .then((response) => {
        console.log(response);
      });
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
