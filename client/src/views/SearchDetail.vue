<template>
    <div class="container">
        <div style="margin-top: 20px" class="d-flex justify-content-center">
            <table style="width:70%;">
                <tr>
                <td>글번호</td>
                <td><b-form-input v-model="board.qnaId" type="text" readonly /></td>
                </tr>
                <tr>
                <td>제목</td>
                <td><b-form-input v-model="board.qnaTitle" type="text" readonly/></td>
                </tr>
                <tr>
                <td>작성자</td>
                <td><b-form-input v-model="board.qnaWriter" type="text" readonly/></td>
                </tr>
                <tr>
                <td>등록일</td>
                <td><b-form-input v-model="board.qnaWriteDate" type="text" readonly/></td>
                </tr>
                <tr>
                <td>문의유형</td>
                <td>
                    <b-form-input v-if="board.qnaType==1" value="회원정보" type="text" readonly/>
                    <b-form-input v-else-if="board.qnaType==2" value="매물등록" type="text" readonly/>
                    <b-form-input v-else-if="board.qnaType==3" value="허위매물신고" type="text" readonly/>
                    <b-form-input v-else-if="board.qnaType==4" value="기타" type="text" readonly/>
                </td>
                </tr>
                <tr>
                <td>내용</td>
                <td><b-form-input style="height:200px;" v-model="board.qnaContent" type="text" readonly /></td>
                </tr>
            </table>
            </div>
            <div class="d-flex justify-content-center" style="margin-top: 10px">
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data(){
        return {
            qnaId: 0,
            board: ''
        };
    },
    created(){
        this.qnaId = this.$route.params.qnaId;
        axios.get('http://localhost:8097/happyhouse/qna/read/' + this.qnaId)
            .then((response) => {
                console.log(response.data);
                this.board = response.data;
            })
    }
}
</script>

<style>

</style>