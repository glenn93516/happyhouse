<template>
    <div id= "header">
        <b-nav class="d-flex justify-content-between align-items-center">
            <b-nav>
                <b-nav-item><router-link to="/"><img src="./../../assets/logo2.png" style="margin-left:30px;" ></router-link></b-nav-item>
                <b-nav-item><router-link to="/"><img src="./../../assets/newlogo.png" style="margin-top:8px;" height="50px"></router-link></b-nav-item>
            </b-nav>
            <b-nav id="loginbar">
                <b-nav-item v-if="isAuthenticated" @click="logout">로그아웃</b-nav-item>
                <b-nav-item v-else><router-link to="/login">로그인</router-link></b-nav-item>
                <b-nav-item><router-link to="/join">회원가입</router-link></b-nav-item>
            </b-nav>
        </b-nav>
        <div class="bottom">
            <b-navbar class="test justify-content-center" toggleable="lg" type="dark">
                <b-navbar-nav class="navout">
                    <b-nav-item class="navitem"><router-link to="/board">공지사항</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/search">매물검색</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/news">오늘의뉴스</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/bookmark">즐겨찾기</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/qna">QnA</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/mypage">마이페이지</router-link></b-nav-item>
                </b-navbar-nav>
            </b-navbar>
        </div>
    </div>
</template>
	
<script>
import {mapGetters} from 'vuex';

export default {
    computed: {
        ...mapGetters['getIsAuthenticated'],
        isAuthenticated() {
            return this.$store.state.isAuthenticated;
        }
    },
    methods: {
        logout: function(){
            this.$store.dispatch('LOGOUT');
            this.$router.push({
                path: '/'
            });
        }
    }
}
</script>

<style>
    .text {
        color: #647409;
    } 
    .test {
        background-color:#d4dca3;
    } 
    .navitem{
        font-family: 'Nanum Gothic', sans-serif;
        text-decoration: none;
        font-weight: 800;
        display:inline-block;
        margin-right:20px; 
        margin-left:50px;
        color:white;
    }
    .navout{
        font-family: 'Nanum Gothic', sans-serif;
        text-align: center;
        margin: 0;
        padding: 0;
    }
    #loginbar{
        font-family: 'Nanum Gothic', sans-serif;
    }
</style>