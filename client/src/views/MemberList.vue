<template>
  <div id="list">
    <div class="d-flex justify-content-center">
      <input
        id="input--search"
        v-on:keyup.enter="search"
        ref="searchBar"
        type="text"
        placeholder="ID를 입력하세요"
      />
      <b-button id="searchBtn" @click="search">검색</b-button>
    </div>
    <div class="d-flex justify-content-center" style="margin-top: 20px">
      <b-table
        :items="idCheck"
        :fields="fields"
        class="table table-hover table-borderless border-0"
        id="membertablelist"
      >
        <template #cell(select)="data">
          <b-form-checkbox
            v-model="selected"
            :value="data.item.userid"
          ></b-form-checkbox>
        </template>
      </b-table>
    </div>
    <b-button id="deleteBtn" style="margin:20px;" @click="deleteMember"
      >계정삭제</b-button
    >
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      members: [],
      selected: '',
      fields: [
        { key: 'userid', label: '아이디' },
        { key: 'userpw', label: '비밀번호' },
        { key: 'username', label: '이름', sortable: true },
        { key: 'useremail', label: '이메일' },
        { key: 'userphone', label: '휴대전화' },
        { key: 'role', label: '권한' },
        { key: 'select', label: '선택' },
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
    deleteMember() {
      axios
        .delete('http://localhost:8097/happyhouse/members/' + this.selected)
        .then((response) => {
          if (response.data == 'success') {
            alert('회원 삭제 성공');

            axios
              .get('http://localhost:8097/happyhouse/members')
              .then((response) => {
                console.log(response);
                this.members = response.data;
              })
              .catch((error) => {
                alert('회원 목록 가져오는 중 오류 발생');
                console.log(error);
              })
              .finally();
          } else if (response.data == 'fail') {
            alert('회원 삭제 실패');
          }
        })
        .catch((error) => {
          alert('회원 삭제 중 오류 발생');
          console.log(error);
        });
    },
  },
  computed: {
    idCheck() {
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
        this.members = response.data;
      })
      .catch((error) => {
        alert('회원 목록 가져오는 중 오류 발생');
        console.log(error);
      })
      .finally();
  },
};
</script>

<style scoped>
table,
td,
th {
  border: 1px solid #dddddd;
  text-align: center;
}
#deleteBtn,
#searchBtn {
  width: 100px;
  height: 3em;
  background-color: #33b3b6;
  border: none;
  border-radius: 0;
  color: #fff;
  padding: 10px 0;
  text-align: center;
  text-decoration: none;
  font-size: 15px;
  margin: 4px;
  cursor: pointer;
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
}
#input--search {
  width: 300px;
  height: 3em; /* 높이값 초기화 */
  margin: 4px;
  line-height: normal; /* line-height 초기화 */
  padding: 0.8em 0.5em; /* 원하는 여백 설정, 상하단 여백으로 높이를 조절 */
  font-family: 'Nanum Gothic', sans-serif; /* 폰트 상속 */
  font-size: 14px;
  font-weight: 600;
  border: 1px solid #f6f6f6;
  background-color: #f6f6f6;
  border-radius: 0; /* iSO 둥근모서리 제거 */
  outline-style: none; /* 포커스시 발생하는 효과 제거를 원한다면 */
  -webkit-appearance: none; /* 브라우저별 기본 스타일링 제거 */
  -moz-appearance: none;
  appearance: none;
}

.container {
  font-family: 'Nanum Gothic', sans-serif;
}
#qnatable {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
}
#membertablelist {
  font-family: 'Nanum Gothic', sans-serif;
  font-weight: 600;
}
</style>
