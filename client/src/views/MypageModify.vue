<template>
  <div id="mypageModify__container">
    <img
      src="./../assets/profile.png"
      width="300px;"
      style="margin-left:30px; margin-top:20px; margin-bottom:20px;"
    />
    <div class="d-flex justify-content-center" style="margin-top: 20px; margin-bottom:20px;">
      <table
        class="table"
        style="width: 600px; table-layout: fixed"
        id="myinfotable"
      >
        <tr>
          <th>아이디</th>
          <td>{{getUserid}}</td>
        </tr>
        <tr>
          <th>이름</th>
          <td>
            {{getUsername}}
            <input
              type="button"
              id="emailModify"
              class="btn btn-outline-primary"
              value="수정"
              style="float:right"
            />
          </td>
        </tr>
        <tr>
          <th>이메일</th>
          <td>
            {{getUseremail}}
            <input
              type="button"
              id="emailModify"
              class="btn btn-outline-primary"
              value="수정"
              style="float:right"
            />
          </td>
        </tr>
        <tr>
          <th>휴대전화</th>
          <td>
            {{getUserphone}}
            <input
              type="button"
              id="phoneModify"
              class="btn btn-outline-primary"
              value="수정"
              style="float:right"
            />
          </td>
        </tr>
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

<style></style>
