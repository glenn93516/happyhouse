<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Document</title>
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
  <style type="text/css">

  </style>
</head>

<body>
  <!-- Footer -->
  <footer class="footer bg-light py-3 my-md-3">
    <!-- 사이트 맵 -->
    <div class="row justify-content-end">
      <div class="col-3">
        <i class="fas fa-home logo pr-1 d-block" style="color:black; font-size: 48px;"></i>
        <small class="text-muted">© 2020</small>
      </div>
      <div class="col-3">
        <h3>Features</h3>
        <ul class="list-unstyled">
          <li><a href="${root}/notice.do" class="text-muted">공지사항</a></li>
          <li><a href="${root}/search.do" class="text-muted">실거래가 검색</a></li>
          <li><a href="${root}/search.do" class="text-muted">관심지역 동네 업종 정보</a></li>
          <li><a href="${root}/search.do" class="text-muted">관심지역 대기 오염 정보</a></li>
        </ul>
      </div>
      <div class="col-3">
        <h3>About</h3>
        <ul class="list-unstyled">
          <li><a href="${root}/introduction.html" class="text-muted">소개</a></li>
          <li><a href="${root}/introduction.html" class="text-muted">위치</a></li>
        </ul>
      </div>
    </div>


    <!-- CopyRight -->
    <div class="container">
      <span class="text-muted float-right">Copyright 2020. 김민혁정다운. ALL RIGHTS RESERVED</span>
    </div>
  </footer>
</body>

</html>
