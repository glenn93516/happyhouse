<template>
    <div class="p-3 mb-2 text-white footer">
        <div id="nav">
            <router-link to="/search">회사소개</router-link> |
            <router-link to="/regist">채용정보</router-link> |
            <router-link to="/regist">이용약관</router-link> |
            <router-link to="/regist">개인정보 처리방침</router-link> |
            <router-link to="/regist">위치기반 서비스 이용약관</router-link> |
            <router-link to="/regist">중개사 사이트 바로가기</router-link> |

            <div class="container">
                <p>상호:(주)UH컴퍼니 | 대표: Autumn LEE | 사업자등록번호: 0433133-0434844 |  <br></p>
                <p>주소:대전광역시 유성구 덕명동 124 207호 대전3반 <br></p>
                <p>서비스 이용문의:042-820-7400 | 이메일: ssafy2020@ssafy.com | 서비스 제휴문의: partnership@ssafy.com<br></p>
            </div>
        </div>
    </div>
</template>

<script>

export default {
}
</script>
<style scoped>

.footer{
    background-color: #39BFBF;
    font-family: 'Nanum Gothic', sans-serif;
}
#nav a {
    color: #fbf6f0;
    text-decoration: none;
    font-weight: 800;
}
#nav a:hover {
    color: #707070;
    transition: all 300ms ease-in;
}

.container{
    font-family: 'Nanum Gothic', sans-serif;
    font-weight: 400;
    color: #fbf6f0;
}
</style>