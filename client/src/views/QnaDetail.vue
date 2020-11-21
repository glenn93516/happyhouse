<template>
    <div class="container">
        <div style="margin-top: 20px" class="d-flex justify-content-center">
            <table style="width:70%;">
                <tr>
                    <td>글번호</td>
                    <td>
                        <b-form-input v-model="board.qnaId" type="text" readonly />
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <b-form-input v-if="isUpdate" v-model="board.qnaTitle" type="text"/>
                        <b-form-input v-else v-model="board.qnaTitle" type="text" readonly/>
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <b-form-input v-model="board.qnaWriter" type="text" readonly/>
                    </td>
                </tr>
                <tr>
                    <td>등록일</td>
                    <td>
                        <b-form-input v-model="board.qnaWriteDate" type="text" readonly/>
                    </td>
                </tr>
                <tr>
                    <td>문의유형</td>
                    <td v-if="isUpdate">
                        <b-form-select v-model="board.qnaType">
                            <option value="1">회원정보</option>
                            <option value="2">매물등록</option>
                            <option value="3">허위매물신고</option>
                            <option value="4">기타</option>
                        </b-form-select>
                    </td>
                    <td v-else>
                        <b-form-input v-if="board.qnaType==1" value="회원정보" type="text" readonly/>
                        <b-form-input v-else-if="board.qnaType==2" value="매물등록" type="text" readonly/>
                        <b-form-input v-else-if="board.qnaType==3" value="허위매물신고" type="text" readonly/>
                        <b-form-input v-else-if="board.qnaType==4" value="기타" type="text" readonly/>
                    </td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <b-form-input v-if="isUpdate" style="height:200px;" v-model="board.qnaContent" type="text" />
                        <b-form-input v-else style="height:200px;" v-model="board.qnaContent" type="text" readonly />
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <router-link to="/qna"><b-button id="listBtn" style="margin:20px;">목록</b-button></router-link>
            <b-button @click="modifyQna" id="modifyBtn" style="margin:20px;">수정</b-button>
            <b-button v-if="!isUpdate" @click="deleteQna" id="deleteBtn" style="margin:20px;">삭제</b-button>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data(){
        return {
            isUpdate: false,
            qnaId: 0,
            board: {}
        };
    },
    created(){
        this.qnaId = this.$route.params.qnaId;
        this.isUpdate = false;
        axios.get('http://localhost:8097/happyhouse/qna/read/' + this.qnaId)
            .then((response) => {
                this.board = response.data;
            })
    },
    methods: {
        modifyQna: function(){
            if(!this.isUpdate) {
                this.isUpdate = true;
            } else {
                axios.put('http://localhost:8097/happyhouse/qna/modify', this.board)
                    .then(({data}) => {
                        if(data == "success"){
                            alert("수정 성공");
                        } else if(data == "fail"){
                            alert("수정에 실패했습니다.");
                        }
                        this.$router.push({
                            path:'/qna'
                        });
                    })
                    .catch((error) => {
                        alert("수정 중 오류 발생");
                        console.log(error);
                    })
            }
        },
        deleteQna: function(){
            axios.delete('http://localhost:8097/happyhouse/qna/delete/' + this.board.qnaId)
                .then(({data}) => {
                    if( data == "success" ) {
                        alert("삭제 성공");
                    } else if (data == "fail" ) {
                        alert("삭제 실패");
                    }
                    this.$router.push({
                        path: '/qna'
                    })
                })
                .catch((error) => {
                    alert("삭제 중 오류 발생");
                    console.log(error);
                })
        }
    }
}
</script>

<style>
#listBtn{
    background-color: #8d9b46;
}
#modifyBtn{
    background-color: #889f00;
}
#deleteBtn{
    background-color: #68770e;
}
</style>