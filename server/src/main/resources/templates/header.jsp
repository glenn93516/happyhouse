<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>메뉴</title>
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
</head>

<body>
    <!-- Navbar -->
	<nav
		class="navbar navbar-expand-sm navbar-default py-3 border-bottom justify-content-between">
		<div class="navbar navbar__logo">
			<i class="fas fa-home logo pr-1"></i> <a class="navbar-brand happy-font title" style="color:#1abc9c" href="${root}/index.jsp"><b>해피</b></a>
		</div>

		<div class="navbar navbar__menu">
			<ul class="navbar-nav menu mx-md-3">
				<c:if test="${not empty loginInfo}">
					<li class="nav-item"><a href="${root}/notice.do?action=listAll" class="nav-link font-weight-bold text-dark">공지사항</a></li>
					<li class="nav-item"><a href="${root}/search.do" class="nav-link font-weight-bold text-dark">실거래가 검색</a></li>
				</c:if>
				<c:if test="${empty loginInfo}">
					<li class="nav-item mr-2"><button class="btn btn-outline-primary mr-2" data-toggle="modal" data-target="#join">회원가입</button></li>
					<li class="nav-item mr-2"><button class="btn btn-outline-primary" data-toggle="modal" data-target="#login">로그인</button></li>
				</c:if>
				<c:if test="${not empty loginInfo}">
					<c:if test="${loginInfo.roll eq 1}"> <!-- 관리자일때만 보이게 -->
						<li class="nav-item"><a href="${root}/member.do?action=search" class="nav-link text-dark"><b>회원검색</b></a></li>
					</c:if>
					<li class="nav-item"><a href="${root}/mypage.jsp" class="nav-link text-dark"><b>마이페이지</b></a></li>
					<li class="nav-item mr-4"><a href="${root}/login.do?action=logout" class="nav-link text-dark">로그아웃</a></li>
					<li class="nav-item ml-3 nav-link text-dark"><b>${loginInfo.username}</b>(${loginInfo.userid})님 환영합니다 :)</li>
				</c:if>
			</ul>

		</div>
	</nav>

    
    <!--Modal-->
	<!--로그인-->
	<div class="modal" id="login">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header justify-content-center">
					<h4 class="modal-title">로그인</h4>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form class="pl-5 pr-5 form form-group" action="${root}/login.do"
						method="post">
						<input type="text" name="id" id="id"
							class="my-2 form-control col-md-12 d-inline" placeholder="아이디"><br>
						<input type="text" name="pw" id="pw"
							class="form-control col-md-12 d-inlinek" placeholder="패스워드">
						<a href="${root}/find.do" class="text-secondary float-right py-2"
							style="font-size: 13px;">비밀번호 찾기</a>
						<button type="submit" class="btn btn-outline-primary col-md-12">로그인</button>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>

	<!--회원가입-->
	<div class="modal" id="join">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header justify-content-center">
					<h4 class="modal-title">회원가입</h4>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form class="pl-5 pr-5 form form-group" action="${root}/member.do" method="post">
						<input type="hidden" name="action" value="join">
						<div class="form-inline form-group col-12">
							<label for="id" class="control-label col-3">아이디<span
								style="color: red;">*</span></span></label>
							<div class="col-9">
								<input type="text" class="form-control" id="id" name="id"
									placeholder="아이디를 입력하세요">
							</div>
						</div>

						<div class="form-inline form-group col-12">
							<label for="pw" class="col-3 control-label">비밀번호<span
								style="color: red;">*</span></label>
							<div class="col-9">
								<input type="password" class="form-control" id="pw" name="pw"
									placeholder="영문 숫자 포함 6자리 이상">
							</div>
						</div>

						<div class="form-inline form-group col-12">
							<label for="name" class="col-3 control-label">이름<span
								style="color: red;">*</span></label>
							<div class="col-9">
								<input type="text" class="form-control" id="name" name="name"
									placeholder="이름을 입력하세요">
							</div>
						</div>

						<div class="form-inline form-group col-12">
							<label for="address" class="col-3 control-label">이메일<span
								style="color: red;">*</span></label>
							<div class="col-9">
								<input type="email" class="form-control" id="email"
									name="email" placeholder="ssafy@naver.com">
							</div>
						</div>

						<div class="form-inline form-group col-12">
							<label for="phone" class="col-3 control-label">전화번호<span
								style="color: red;">*</span></label>
							<div class="col-9">
								<input type="text" class="form-control" id="phone" name="phone"
									placeholder="010-xxxx-xxxx">
							</div>
						</div>
						<button type="submit" class="btn btn-outline-primary col-md-12">회원가입</button>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
</body>

</html>
