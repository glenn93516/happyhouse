<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous">
    </script>
    <script src="https://sta.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/5d2954c3f8.js" crossorigin="anonymous"></script>
<title>Document</title>
<style type="text/css">
.card-text{
    border-radius: 5px;
    background-color: rgb(255, 255, 255);
	margin-bottom:0px;
}

h4{
margin-bottom:0px;
}

</style>
</head>

<body>
	<jsp:include page="header.jsp" />

	<!-- Contents -->
	<div class="container contents">
		<div class="jumbotron text-center bg-transparent pb-0">
			<h6 class="display-4">
				<span style="color: #1abc9c;">어떤 동네, 어떤 방</span>에서<br>살고 싶으신가요?
			</h6>
			<hr class="my-4">
			<div class="btn-group">
				<form action="${root}/search.do" action="get" class="form-inline">
					<script type="text/javascript">
			            $(document).ready(function(){
							$.get("${root}/map"
								,{act:"sido"}
								,function(data, status){
									$.each(data, function(index, vo) {
										$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
									});//each
								}//function
								, "json"
							);//get
						});//ready
						$(document).ready(function(){
							$("#sido").change(function() {
								$.get("${root}/map"
									,{act:"gugun", sido:$("#sido").val()}
									,function(data, status){
										$("#gugun").empty();
										$("#gugun").append('<option selected disabled>구/군</option>');
										$.each(data, function(index, vo) {
											$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
										});//each
									}//function
									, "json"
								);//get
							});//change
							$("#gugun").change(function() {
								$.get("${root}/map"
									,{act:"dong", gugun:$("#gugun").val()}
									,function(data, status){
										$("#dong").empty();
										$("#dong").append('<option selected disabled>동</option>');
										$.each(data, function(index, vo) {
											$("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
										});//each
									}//function
									, "json"
								);//get
							});//change
						});//ready
					</script>
					<div class="form-group mx-md-1">
						<select name="sido" id="sido" class="form-control">
							<option selected disabled>시/도</option>
						</select>
					</div>
					<div class="form-group mx-md-1">
						<select name="gugun" id="gugun" class="form-control">
							<option selected disabled>구/군</option>
						</select>
					</div>
					<div class="form-group">
						<select name="dong" id="dong" class="form-control" placeholder="동">
							<option selected disabled>동</option>
						</select>
					</div>
					<div class="form-group mx-md-1">
						<select name="houseType" id="houseType" class="form-control">
							<option selected disabled>주거/매물형태</option>
							<option value="apt">아파트</option>
							<option value="houses">연립주택</option>
						</select>
					</div>
					<div class="form-group">
						<input name="aptName" type="text" class="form-control mx-md-1"
							placeholder="아파트(주택)명으로 검색하기">
						<button class="btn btn-success" type="submit"
							style="background-color: #1abc9c;">찾아보기</button>
					</div>
				</form>
			</div>
			<hr class="my-5" style="width: 70%">
		</div>
		<div class="container product-container">
			<nav
				class="navbar navbar-expand-md navbar-light bg-transparent pl-0 pb-0">
				<ul class="navbar-nav" >
					<!-- <li class="nav-item"><a href="#"
						class="nav-link active font-weight-bold">
							<h3>최근 본 방</h3>
					</a></li> -->
					<li class="nav-item"><a href="#" class="nav-link active font-weight-bold">
						<c:if test="${not empty loginInfo}"><!-- 로그인 했을때만 -->
							<h3>${loginInfo.username}의 관심 매물</h3>
						</c:if>
					</a></li>
					<!-- <li class="nav-item"><a href="#"
						class="nav-link font-weight-bold">
							<h3>찜한 방</h3>
					</a></li> -->
				</ul>
			</nav>
			<p class="pl-md-2">최근에 찜한 관심 매물을 볼 수 있어요</p>
			<div class="container text-center">
			<c:if test="${not empty loginInfo && empty interList}">
				<script type="text/javascript">
				$(function(){
					location.href = '${root}/interest.do?action=getInterest';
				});
				</script>
			</c:if>
				<div id="interest_result" class="card d-inline-block" style="position:relative 0 0; width: 1180px; border:none;">
			<c:forEach items="${interList}" var="dto">
					<c:if test="${not empty interList}">
						<div class="card-body p-md-1 float-left text-left mr-2" style="width: 280px; height: 325px;">
							<p class="card-text pt-1"><img src="${root}/img/room_sample.PNG" alt="" style="width: 280px; height: 186px;"></p>
							<h5 class="card-text pt-2">${dto.aptName}</h5>
							<p class="card-text pt-1" style="font-size:20px;"><b>가격${dto.dealAmount}원</b></p>
							<p class="card-text pt-1"  style="font-size:14px; color:#333;"><span>${dto.floor}층</span></p>
							<p class="card-text pt-1" style="font-size:14px; color:#666;"><span style="font-size:15px;">면적 </span><span>${dto.area}</span></p>
						</div>
					</c:if>
			</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="footer.jsp" />
</body>

</html>
