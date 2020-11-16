<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>공지 검색결과</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/5d2954c3f8.js" crossorigin="anonymous"></script>
    <!--CSS-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!--JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!--web font-->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body>
    <jsp:include page="header.jsp" />
    
    <div class="container text-center mt-5" style="margin-bottom:0">
        <h3>검색결과</h3>
    </div>

    <nav class="container navbar navbar-expand-sm navbar-light">
    	<c:if test="${loginInfo.roll eq 1}"><!-- 관리자일때만 -->
        	<button id="btnWrite" class="btn btn-outline-primary"><a href="${root}/noticeWrite.jsp">글쓰기</a></button>
        </c:if>
        <form class="navbar-nav ml-auto" action="${root}/notice.do" method="post">
        <input type="hidden" name="action" value="search">
            <div class="form-group mr-1">
                <select class="form-control" name="search_type">
                    <option value="btitle">제목</option>
                    <option value="bcontent">내용</option>
                    <option value="userid">글쓴이</option>
                </select>
            </div>
            <div class="form-group mr-1">
                <input type="text" id="userId" class="form-control" name="userId" placeholder="검색어 입력.">
            </div>
            <div class="form-group">
                <button id="btnWrite" class="btn btn-outline-primary">검색</button>
            </div>
            </div>
        </form>
    </nav>

  <!--contents-->
  <div class="container my-3">
    <form role="form" method="get">
      <table class="table table-hover">
        <thead>
          <tr>
            <th width="15%">글번호</th>
            <th width="40%" class="text-center">제목</th>
            <th width="15%">작성자</th>
            <th width="15%">조회수</th>
            <th width="15%">작성일</th>
          </tr>
        </thead>
        <c:choose>
			<c:when test="${empty resultList}">
				<tr><td colspan="5">검색된 결과가 없습니다.</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${resultList}" var="dto">
					<tr>
						<td>${dto.bnum}</td>
						<td id="title"><a href="notice.do?action=read&bnum=${dto.bnum}">${dto.btitle}</a></td>
						<td>${dto.userid}</td>
						<td>${dto.bread_cnt}</td>
						<td>${dto.bwritedate}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
      </table>
    </form>
  </div>

    <!-- Footer -->
	<jsp:include page="footer.jsp" />
</body>

</html></html>
