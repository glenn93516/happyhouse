<template>
    <div>
        <b-navbar class="mypagenav justify-content-center" toggleable="lg" type="dark">
                <b-navbar-nav class="navout">
                    <b-nav-item class="navitem"><router-link to="/mypage">내 정보</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/mypage/modify">내 정보수정</router-link></b-nav-item>
                    <b-nav-item class="navitem"><router-link to="/mypage/manage">회원관리</router-link></b-nav-item>
                </b-navbar-nav>
            </b-navbar>
        <hr/>     
    </div>
</template>

<script>
export default {

}
</script>

<style>
.mypagenav{
    background-color: white;
    font-family: 'Nanum Gothic', sans-serif;
    font-weight: 400;
}
</style>