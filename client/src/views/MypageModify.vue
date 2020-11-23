<template>
    <div>
        <h1>회원정보수정</h1>
        <img src="./../assets/profile.png" width="300px;" style="margin-left:30px;" />
        <div class="d-flex justify-content-center" style="margin-top: 20px">
            <table class="table" style="width: 600px; table-layout: fixed" id="myinfotable">
                <tr>
                    <th>아이디</th>
                    <td>ssafy</td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td>이지은
                        <input type="button" id="emailModify" class="btn btn-outline-primary" value="수정"  style="float:right">
                    </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td>ssafy@gmail.com
                        <input type="button" id="emailModify" class="btn btn-outline-primary" value="수정"  style="float:right">
                    </td>
                </tr>
                <tr>
                    <th>휴대전화</th>
                    <td>010-9305-1628
                        <input type="button" id="phoneModify" class="btn btn-outline-primary" value="수정"  style="float:right">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style>

</style>