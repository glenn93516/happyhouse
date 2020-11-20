<template>
    <div id= "header">
        <b-nav class="d-flex justify-content-between align-items-center">
            <b-nav>
                <b-nav-item><router-link to="/"><img src="./../../assets/logo2.png" style="margin-left:30px;" ></router-link></b-nav-item>
                <b-nav-item><router-link to="/"><img src="./../../assets/newlogo.png" style="margin-top:8px;" height="50px"></router-link></b-nav-item>
            </b-nav>
            <b-nav id="loginbar">
                <b-nav-item><router-link to="/login">로그인</router-link></b-nav-item>
                <b-nav-item><router-link to="/join">회원가입</router-link></b-nav-item>
            </b-nav>
        </b-nav>
        <div class="bottom">
            <b-navbar class="test justify-content-center" toggleable="lg" type="dark">
                <b-navbar-nav class="navout">
                    <b-nav-item class="navitem"><router-link to="/">공지사항</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/">매물검색</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/">오늘의뉴스</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/">즐겨찾기</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/qna">QnA</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/">마이페이지</router-link></b-nav-item>
                </b-navbar-nav>
            </b-navbar>
        </div>
    </div>
</template>
	
<script>
export default {

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