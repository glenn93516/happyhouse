<template>
    <div id="list">
      <h1 style="margin:30px;">회원관리(관리자모드)</h1>
      <hr/>
      <div class="d-flex justify-content-center">
        <input
          v-on:keyup.enter="search"
          ref="searchBar"
          type="text"
          style="width: 300px; margin-right: 10px"
        />
        <b-button variant="primary" @click="search" style="margin-right: 10px">검색</b-button>
      </div>
      <div class="d-flex justify-content-center" style="margin-top: 20px">
        <table v-show="isSearch" style="width: 600px; table-layout: fixed" id="qnatable">
          <thead>
            <tr class="table-primary">
              <th>아이디</th>
              <th>비밀번호</th>
              <th>이름</th>
              <th>이메일</th>
              <th>휴대전화</th>
              <th>권한</th>
              <th>선택</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="member in idCheck" :key="member.userid">
              <td><router-link :to="'/mypage/' + member.userid">{{ member.userid }}</router-link></td>
              <td>{{ member.userpwd }}</td>
              <td>{{ member.username }}</td>
              <td>{{ member.useremail }}</td>
              <td>{{ member.userphone }}</td>
              <td>{{ member.role }}</td>
              <td><input type="checkbox" name="selected" id="selected"></td>
            </tr>
          </tbody>
        </table>
      </div>
      <b-button id="deleteBtn" style="margin:20px;">계정삭제</b-button>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data(){
        return {
            members: [],
            searchCondition: '',
            isSearch: true,
        };
    },
    method: {
        search() {
            this.searchCondition = this.$refs.searchBar.value;
            this.isSearch = true;
        },
    },
    computed: {
        idCheck(){
            return this.members.filter((member) => {
                return member.userid.includes(this.searchCondition);
            });
        },
    },
    created() {
        axios
        .get(
            'http://localhose:8097/happyhouse/members/list/1',
            this.searchCondition
        )
        .then((response) => {
            this.members = response.data.memberList;
        })
        .catch()
        .finally();
    }
}
</script>

<style>
table,
td,
th {
  border: 1px solid #dddddd;
  text-align: center;
}
#deleteBtn{
  background-color: #8d9b46;
  text-align: right;
}
.container{
  font-family: 'Nanum Gothic', sans-serif;
}
#qnatable{
    font-family: 'Nanum Gothic', sans-serif;
    font-weight: 400;
}
</style>