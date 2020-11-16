<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/5d2954c3f8.js" crossorigin="anonymous"></script> <!-- fontawesome -->
    <style type="text/css">
        #map {
            width: 45%;
            height: 1000px;
        }
        
         .interest:hover{
        	cursor: pointer;
        }
    </style>
    <title>Document</title>
</head>

<body>
    <!-- Navbar -->
    <jsp:include page="header.jsp" />

    <!-- Contents -->
    <div class="container-fluid contents">
            <%-- 시/도, 구/군, 동 데이터 읽어와 갱신 --%>
            <script type="text/javascript">
	            $(document).ready(function(){
	            	// TODO
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
        <!-- 매물 전체 검색화면 navbar -->
        <form action="${root}/search.do" method="get" class="form-inline justify-content-between mt-md-2">
            <div class="form-group">
                <input name="aptName" type="text" class="form-control mx-md-1" placeholder="아파트 이름 입력" style="border:0; font-size:24px">
                <button class="btn"><i class="fas fa-search" style="font-size: 24px; color: #1abc9c"></i></button>
            </div>
            <div class="form-group">
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
                <div class="form-group mx-md-1">
                    <select name="sortType" id="sortType" class="form-control">
                        <option selected disabled>정렬기준</option>
                        <option value="price">가격순</option>
                        <option value="area">면적순</option>
                        <option value="floor">층별</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
            	<button type="button" id="btn__safetyHospital" class="btn border btn-sm" value="">주변 국민안심병원 </button>
            	<button type="button" id="btn__covidTestCenter" class="btn border btn-sm" value="">주변 코로나 선별 진료소</button>
            	<button type="button" id="btn__convenienceStore" class="btn border btn-sm" value="">주변 편의점</button>
                <button class="btn" type="reset"><i class="fas fa-redo-alt"
                        style="font-size: 24px; color: #1abc9c"></i></button>
            </div>
        </form>
        <hr>

        <!-- 검색화면 컨텐츠 -->
        <div class="container-fluid search-results w-100 pl-0">
        	<!-- 주변 국민 안심병원, 코로나 선별 진료소 출력 -->
        	<c:if test="${not empty dealList}">
        		<script type="text/javascript">
        			$(document).ready(function(){
        				function markHospital(hospital){
        					$.get("https://maps.googleapis.com/maps/api/geocode/json"
									,{	key:'AIzaSyBlekbMYnxJdpvOtcnYGMy95jExThA9Ees'
										, address: hospital.address
									}
									, function(data, status) {
										tmpLat = data.results[0].geometry.location.lat;
										tmpLng = data.results[0].geometry.location.lng;
										addHospitalMarker(tmpLat, tmpLng, hospital["hospital_name"]);
									}
									, "json"
							);//get
        				}
        				$('#btn__safetyHospital').click(function(){
            				$.get("${root}/hospital.do"
        							,{action:"safetyhospital", houseinfoId:"${dealList[0].houseinfoId}"}
        							,function(data, status){
        								console.log(data);
        								$.each(data, function(index, vo) {
        									markHospital(vo);
        								});//each
        							}//function
        							, "json"
       							);//get
            			});
            			$('#btn__covidTestCenter').click(function(){
            				$.get("${root}/hospital.do"
        							,{action:"covidtestcenter", houseinfoId:"${dealList[0].houseinfoId}"}
        							,function(data, status){
        								console.log(data);
        								$.each(data, function(index, vo) {
        									markHospital(vo);
        								});//each
        							}//function
        							, "json"
       							);//get
            			});
        			})
        			console.log("${dealList[0].houseinfoId}");
        		</script>
        	</c:if>
            <!-- 매물 목록 -->
            <div id="item-list" class="d-inline-block w-50 overflow-auto">
                <header>
                    <h3>전체 방 ${fn:length(dealList)}개</h3> 
                    <hr>
                </header>
                <c:choose>
                	<c:when test="${not empty dealList}">
               			<c:set var="itemIdx" value="0"></c:set>
                		<c:forEach items="${dealList}" var="dto">
	                        <div id="item__${itemIdx}" class="card d-inline-block" style="position:relative 0 0; border: none; width: 160px; height: 100px;">
	                        	<i id="interest_${itemIdx}" class="fas fa-heart interest" style="color:#1abc9c; display:inline-block;">찜하기</i>
	                        	    <script>
	                        	    	$("#interest_${itemIdx}").on("click", function () {
											$(location).attr('href','${root}/interest.do?action=setInterest&dealId=${dto.dealId}');
	                        	    	});
     								</script>
	                            <img src="${root}/img/room_sample.PNG" alt="" style="width: 140px; height: 100px;">
	                            <div class="card-body p-md-1">
	                                <p class="card-text">
	                                    <h5 class="font-weight-bold">${dto.aptName} 
	                                    <button class="btn btn-sm btn-primary disabled">아파트</button></h5>
	                                </p>
	                                <p class="card-text font-weight-bold">
	                                    	전세 ${dto.dealAmount}만원
	                                </p>
	                                <p class="card-text">
	                                    	${dto.floor}층, ${dto.area}m
	                                </p>
	                            </div>
	                        </div>
							                     
	                        <script type="text/javascript">
		                        $.get("https://maps.googleapis.com/maps/api/geocode/json"
										,{	key:'AIzaSyBlekbMYnxJdpvOtcnYGMy95jExThA9Ees'
											, address: "${dto.dong}" + "+" + "${dto.aptName}" + "+" + "${dto.jibun}"
										}
										, function(data, status) {
											tmpLat = data.results[0].geometry.location.lat;
											tmpLng = data.results[0].geometry.location.lng;
											addMarker(tmpLat, tmpLng, "${dto.aptName}");
										}
										, "json"
								);//get
								
								// 매물 상세 정보 
								$('#item__${itemIdx}').click( function() {
									if("${loginInfo}" != null && "${loginInfo}" != "") {
										$('#item-list').empty();
										let str = '<header><h3><button id="back" class="btn"><i class="fas fa-arrow-left"></i></button>'
											+ "${dto.aptName}" + '</h3>'
											+ '<hr> </header><div class="item container w-100"><img src="${root}/img/result_detail_sample.jpg" alt="" width="100%">'
											+ '<div class="item__content container px-md-5"><h1 class="font-weight-bold">'
					                    	+ "매매" + "${dto.dealAmount}만원" + '</h1>'
					                    	+ '<p>' + '확인 날짜 : ${dto.dealYear}-${dto.dealMonth}-${dto.dealDay}' + '<br>'
						                    + '<hr class="mb-md-3" style="border-color: orange;">'
						                    + '</p>'
						                    + '<table class="table">'
						                    + '<tr>'
						                    + '<th>전용 면적</th>'
						                    + '<td>' + '${dto.area}m' + '</td>'
											+ '</tr>'
											+ '<tr>'
											+ '<th>거래 구분</th>'
											+ '<td>아파트</td>'
											+ '</tr>'
											+ '<tr>'
											+ '<th>층</th>'
											+ '<td>' + '${dto.floor}층' + '</td>'
											+ '</tr>'
											+ '</table>'
											+ '</div></div>';
										$('#item-list').append(str);
										$('#back').click(function(){
											location.href = "${root}" + "/search.do";
										});
										setCenterSelectedItem("${dto.lat}", "${dto.lng}");
									} else {
										alert("상세보기는 로그인 후 사용 가능합니다");
									}
								});
	                        </script>
	                        
	                        <c:set var="itemIdx" value="${itemIdx + 1}"></c:set>
                		</c:forEach>
                	</c:when>
                	<c:otherwise>
                		<h1>매물이 없습니다 ㅠㅠ</h1>
                	</c:otherwise>
                </c:choose>
            </div>

            <!-- 지도 -->
            <div id="map" class="d-inline-block w-40 m-md-2">
				<script src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
				<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBlekbMYnxJdpvOtcnYGMy95jExThA9Ees&callback=initMap"></script>
                <script type="text/javascript">
                    const labels = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    let labelIndex = 0;
                    var map;
                    var start = {lat: 37.5665734, lng: 126.978179};

                    function showStoreInfo(controlDiv, map) {
                        // Set CSS for the control border.
                        var controlUI = document.createElement('div');
                        controlUI.style.backgroundColor = 'white';
                        controlUI.style.borderRadius = '3px';
                        controlUI.style.cursor = 'pointer';
                        controlUI.style.marginRight = '8px';
                        controlUI.style.marginTop = '12px';
                        controlUI.style.marginBottom = '22px';
                        controlUI.style.textAlign = 'center';
                        controlUI.title = '현재 동네 상권 정보 표시';
                        controlDiv.appendChild(controlUI);

                        // Set CSS for the control interior.
                        var controlText = document.createElement('div');
                        controlText.style.color = 'black';
                        controlText.style.fontFamily = 'Nanum Gothic', 'sans-serif';
                        controlText.style.fontSize = '16px';
                        controlText.style.lineHeight = '38px';
                        controlText.style.paddingLeft = '5px';
                        controlText.style.paddingRight = '5px';
                        controlText.textContent = '주변 상권 표시';
                        controlUI.appendChild(controlText);

                        // Setup the click event listeners: simply set the map to Chicago.
                        controlUI.addEventListener('click', function () {
                            addMarker({
                                lat: 37.01,
                                lng: 127.01
                            }, map);

                            addMarker({
                                lat: 37.01,
                                lng: 127.02
                            }, map);

                            addMarker({
                                lat: 37.01,
                                lng: 127.03
                            }, map);

                            addMarker({
                                lat: 37.02,
                                lng: 127
                            }, map);

                            addMarker({
                                lat: 36.99,
                                lng: 127
                            }, map);
                        });
                    }

                    function showAirQualityInfo(controlDiv, map) {
                        // Set CSS for the control border.
                        var controlUI = document.createElement('div');
                        controlUI.style.backgroundColor = 'white';
                        controlUI.style.borderRadius = '3px';
                        controlUI.style.cursor = 'pointer';
                        controlUI.style.marginTop = '12px';
                        controlUI.style.marginBottom = '22px';
                        controlUI.style.marginRight = '8px';
                        controlUI.style.textAlign = 'center';
                        controlUI.title = '주변 대기오염 정보 출력';
                        controlDiv.appendChild(controlUI);

                        // Set CSS for the control interior.
                        var controlText = document.createElement('div');
                        controlText.style.color = 'black';
                        controlText.style.fontFamily = 'Nanum Gothic', 'sans-serif';
                        controlText.style.fontSize = '16px';
                        controlText.style.lineHeight = '38px';
                        controlText.style.paddingLeft = '5px';
                        controlText.style.paddingRight = '5px';
                        controlText.textContent = '미세먼지 농도 표시';
                        controlUI.appendChild(controlText);

                        // Setup the click event listeners: simply set the map to Chicago.
                        controlUI.addEventListener('click', function () {
                            addAirQualityMarker(start, map);
                        });
                    }

                    function initMap() {
                        map = new google.maps.Map(document.getElementById('map'), {
                            zoom: 14,
                            center: start
                        });

                        var storeInfoControlDiv = document.createElement('div');
                        var airQualityInfoControlDiv = document.createElement('div');

                        var storeInfoControl = new showStoreInfo(storeInfoControlDiv, map);
                        var airQualityInfoControl = new showAirQualityInfo(airQualityInfoControlDiv, map);

                        storeInfoControlDiv.index = 1;
                        airQualityInfoControlDiv.index = 1;
                        map.controls[google.maps.ControlPosition.TOP_CENTER].push(storeInfoControlDiv);
                        map.controls[google.maps.ControlPosition.TOP_CENTER].push(airQualityInfoControlDiv);
                    }

                    function addMarker(location, map) {
                        new google.maps.Marker({
                            position: location,
                            label: labels[labelIndex++ % labels.length],
                            map: map
                        });
                    }
					
                    function setCenterSelectedItem(tmpLat, tmpLng){
                    	console.log(tmpLat, tmpLng);
                    	map.setZoom(17);
                    	map.setCenter({lat : tmpLat, lng:tmpLng});
                    }
                    
                    function addMarker(tmpLat, tmpLng, aptName){
                    	var marker = new google.maps.Marker({
							position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
							label: aptName,
							title: aptName
						});
						marker.addListener('click', function() {
							map.setZoom(17);
							map.setCenter(marker.getPosition());
						});
						marker.setMap(map);
						map.setCenter(marker.getPosition());
                    }
                    
                    function addHospitalMarker(tmpLat, tmpLng, hospitalName){
                    	var marker = new google.maps.Marker({
							position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
							label: hospitalName,
							title: hospitalName,
							icon: {
							      url: "http://maps.google.com/mapfiles/ms/icons/blue-dot.png"
							}
						});
						marker.addListener('click', function() {
							map.setZoom(17);
							map.setCenter(marker.getPosition());
						});
						marker.setMap(map);
						map.setCenter(marker.getPosition());
                    }
                    
                    function addAirQualityMarker(location, map) {
                        const contentString =
                            '<div id="content">' +
                            '<div id="siteNotice">' +
                            "</div>" +
                            '<h3 id="firstHeading" class="firstHeading">종로구</h3>' +
                            '<div id="bodyContent">' +
                            '<h5 style="color: blue; text-align:center;">37</h5>' +
                            "</div>" +
                            "</div>";
                        const infowindow = new google.maps.InfoWindow({
                            content: contentString
                        });
                        const marker = new google.maps.Marker({
                            position: start,
                            map,
                            title: '종로구 대기정보'
                        });

                        marker.addListener('click', function () {
                            infowindow.open(map, marker);
                        })
                    }
                </script>
            </div>
        </div>
    </div>
    <!-- Footer -->
    <jsp:include page="footer.jsp" />
</body>

</html>
