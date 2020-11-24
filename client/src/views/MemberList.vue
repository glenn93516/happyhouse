<template>
    <div id="list">
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
        <b-table 
          :items="members"
          :fields="fields"
        >
        <template #cell(select)="data">
          <b-form-checkbox>{{data}}</b-form-checkbox>
        </template>
        </b-table>
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
            fields: [
              {key: 'userid', label:'아이디'}, 
              {key: 'userpw', label: '비밀번호'}, 
              {key: 'username', label: '이름', sortable: true}, 
              {key: 'useremail', label: '이메일'}, 
              {key: 'userphone', label: '휴대전화'},
              {key: 'role', label: '권한'}, 
              {key: 'select', label: '선택'}
            ],
            searchCondition: '',
            isSearch: true,
        };
    },
    methods: {
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
        .get('http://localhost:8097/happyhouse/members')
        .then((response) => {
          console.log(response);
          this.members= response.data;
        })
        .catch((error) => {
          alert("회원 목록 가져오는 중 오류 발생");
          console.log(error);
        })
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