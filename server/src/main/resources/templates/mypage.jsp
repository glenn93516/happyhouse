<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/5d2954c3f8.js" crossorigin="anonymous"></script>
    <!--CSS-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!--JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!--web font-->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style.css" />
    <script>
        $(function () {
            $("#con1").css("display", "block");
            $(".menu").on("click", function () {
                let id = $(this).attr("id");
                let idArr = id.split("");
                var num = idArr[3];
                let currentCon = "con" + num;
                $("#" + currentCon).css("display", "block");

                //나머지 콘텐츠 숨기기
                for (let i = 1; i <= 2; i++) {
                    if (i == num) continue;
                    let hideCon = "con" + i;
                    $("#" + hideCon).css("display", "none");
                }

                return false;
            });
        });
    </script>
</head>

<body>
    <jsp:include page="header.jsp" />

    <!--content-->
    <div class="container text-center col-lg-12">
        <h2 class="pt-5 py-5"">마이 페이지</h2>
        <div class="menu col-md-12 py-3">
            <div id="div1" class="col-md-3 d-inline pr-5 pl-5 border-bottom py-3 menu d-none"><a class="text-secondary"
                    href="#">내 정보</a></div>
            <div id="div2" class="col-md-3 d-inline pr-5 pl-5 border-bottom py-3 menu d-none"><a class="text-secondary"
                    href="#">정보 수정</a></div>
            <div id="div3" class="col-md-3 d-inline pr-5 pl-5 border-bottom py-3 d-none"><a class="text-secondary"
                    data-toggle="modal" data-target="#delete" href="">탈퇴하기</a></div>
        </div>

        <!--내 정보-->
        <div id="con1" class="collapse mt-5 my-auto ">
            <div class="content container">
                <div class="header">
                    <h4 class="modal-title my-5">내 정보</h4>
                </div>

                <form>
                    <div class="form-group row justify-content-center">
                        <label for="id" class="col-md-2 col-form-label text-right">아이디<span
                                style="color: red;">*</span></span></label>
                        <div class="col-md-5">
                            <input type="text" class="form-control bg-transparent border-0" value="${loginInfo.userid}" readonly>
                        </div>
                    </div>
                    <div class="form-group row justify-content-center">
                        <label for="id" class="col-md-2 col-form-label text-right">비밀번호<span
                                style="color: red;">*</span></span></label>
                        <div class="col-md-5">
                            <input type="text" class="form-control bg-transparent border-0" value="${loginInfo.userpw}"
                                readonly>
                        </div>
                    </div>
                    <div class="form-group row justify-content-center">
                        <label for="id" class="col-md-2 col-form-label text-right">이름<span
                                style="color: red;">*</span></span></label>
                        <div class="col-md-5">
                            <input type="text" class="form-control bg-transparent border-0" value="${loginInfo.username}" readonly>
                        </div>
                    </div>
                    <div class="form-group row justify-content-center">
                        <label for="id" class="col-md-2 col-form-label text-right">이메일<span
                                style="color: red;">*</span></span></label>
                        <div class="col-md-5">
                            <input type="email" class="form-control bg-transparent border-0"
                                value="${loginInfo.useremail}" readonly>
                        </div>
                    </div>
                    <div class="form-group row justify-content-center">
                        <label for="id" class="col-md-2 col-form-label text-right">전화번호<span
                                style="color: red;">*</span></span></label>
                        <div class="col-md-5">
                            <input type="tel" class="form-control bg-transparent border-0" value="${loginInfo.userphone}"
                                readonly>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <!--정보수정-->
        <div id="con2" class="collapse mt-5 my-auto ">
            <div class="content container">
                <div class="header justify-content-center">
                    <h4 class="modal-title my-5">정보 수정</h4>
                </div>

                <form class="form form-group" action="${root}/member.do" method="post">
                	<input type="hidden" name="action" value="update">
                    <div class="form-group row justify-content-center col-md-12">
                        <label for="id" class="col-md-2 col-form-label text-right">아이디</label>
                        <div class="col-md-5">
                            <input type="text" name="id" class="form-control" value="${loginInfo.userid}" readonly>
                        </div>
                    </div>
                    <div class="form-group row justify-content-center col-md-12">
                        <label for="id" class="col-md-2 col-form-label text-right">비밀번호<span
                                style="color: red;">*</span></label>
                        <div class="col-md-5">
                            <input type="text" name="pw" class="form-control" value="${loginInfo.userpw}">
                        </div>
                    </div>
                    <div class="form-group row justify-content-center col-md-12">
                        <label for="id" class="col-md-2 col-form-label text-right">이름<span
                                style="color: red;">*</span></label>
                        <div class="col-md-5">
                            <input type="text" name="name" class="form-control" value="${loginInfo.username}">
                        </div>
                    </div>
                    <div class="form-group row justify-content-center col-md-12">
                        <label for="id" class="col-md-2 col-form-label text-right">이메일<span
                                style="color: red;">*</span></label>
                        <div class="col-md-5">
                            <input type="email" name="email" class="form-control"
                                value="${loginInfo.useremail}">
                        </div>
                    </div>
                    <div class="form-group row justify-content-center col-md-12">
                        <label for="id" class="col-md-2 col-form-label text-right">전화번호<span
                                style="color: red;">*</span></label>
                        <div class="col-md-5">
                            <input type="tel" name="phone" class="form-control" value="${loginInfo.userphone}">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-outline-primary col-md-3 mt-3 mb-5">수정완료</button>
                </form>
            </div>
        </div>
    </div>


    <!--modal-->
    <div class="modal" id="delete">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header justify-content-center">
                    <h4 class="modal-title">탈퇴하기</h4>
                </div>

                <!-- Modal body -->
                <div class="modal-body text-center">
                    <p>정말 탈퇴하시겠습니까?</p>
                    <button class="btn btn-outline-primary" onclick="location.href='${root}/member.do?action=delete&userid=${loginInfo.userid}'">확인</button>
                    <button class="btn btn-danger" data-dismiss="modal">취소</button>
                </div>

            </div>
        </div>
    </div>
    <!--modal-->
    <!--content-->

    <!-- Footer -->
	<jsp:include page="footer.jsp" />
</body>

</html>
