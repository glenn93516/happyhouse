<template>
  <div id="mypageInfo__container">
    <img
      src="./../assets/profile.png"
      width="300px;"
      style="margin-left:30px; margin-top:20px; margin-bottom:20px;"
    />
    <div
      class="d-flex justify-content-center border-0"
      style="margin-top: 20px; margin-bottom: 20px;border-style:none;"
    >
      <table
        class="table table-borderless border-0"
        style="width: 600px; table-layout: fixed;"
        id="myinfotable"
      >
        <!-- <tr>
          <th>ID</th>
          <td>{{ getUserid }}</td>
        </tr>
        <tr>
          <th>NAME</th>
          <td>{{ getUsername }}</td>
        </tr>
        <tr>
          <th>E-MAIL</th>
          <td>{{ getUseremail }}</td>
        </tr>
        <tr>
          <th>PHONE</th>
          <td>{{ getUserid }}</td>
        </tr> -->
        <b-row id="rowId">
          <b-col>ID</b-col>
          <b-col>{{ getUserid }}</b-col>
        </b-row>
        <b-row id="rowName">
          <b-col>NAME</b-col>
          <b-col>{{ getUsername }}</b-col>
        </b-row>
        <b-row id="rowEmail">
          <b-col>E-MAIL</b-col>
          <b-col>{{ getUseremail }}</b-col>
        </b-row>
        <b-row id="rowPhone">
          <b-col>PHONE</b-col>
          <b-col>{{ getUserphone }}</b-col>
        </b-row>
      </table>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['getUserid', 'getUsername', 'getUseremail', 'getUserphone']),
  },
};
</script>

<style>
#mypageInfo__container {
  color: #707070;
  font-family: 'Nanum Gothic', sans-serif; /* 폰트 상속 */
  font-size: 20px;
  font-weight: 550;
}

#rowId,
#rowName,
#rowEmail,
#rowPhone {
  color: #707070;
  -webkit-appearance: none; /* 브라우저별 기본 스타일링 제거 */
  -moz-appearance: none;
  height: 3em; /* 높이값 초기화 */
  line-height: normal; /* line-height 초기화 */
  padding: 0.8em 0.5em; /* 원하는 여백 설정, 상하단 여백으로 높이를 조절 */
  background-color: #f6f6f6;
  border-radius: 0; /* iSO 둥근모서리 제거 */
}

table {
  background-color: #f6f6f6;
  border: 0;
}
tr {
  color: #707070;
}
td {
  text-align: left;
}
</style>
