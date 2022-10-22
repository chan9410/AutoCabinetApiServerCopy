<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="/css/main.css"></link>
<link rel="stylesheet" href="/css/btn-style.css"></link>

<script defer type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<script defer type="text/javascript" src="/js/tagCabinet.js"></script>


<title>AutoCabinet</title>
</head>
<body>
	<c:import url="/WEB-INF/views/navbar.jsp" />

	<div class="main-layout">
		<!--실시간 재고 영역 시작-->
		<!-- <section id="live-stock">실시간 안테나</section> -->
		<section id="live-stock">

			<div id="createBox"></div>

		</section>

		<!--실시간 재고 영역 끝-->

		<!-- 제품찾기 영역 시작-->
		<section id="product-search">
			<div class="product-search-title">
				<span>제품 찾기</span>
				<button id="reset-search-data-btn">초기화</button>
			</div>
			<div class="product-search-btn-container">
				<input id="individual-search-btn" type="button" class="common-btn"
					value="개별 찾기" /> <input id="group-search-btn" type="button"
					class="common-btn" value="그룹 찾기" />
			</div>
			<div class="product-search-result">
			</div>
		</section>
		<!-- 제품찾기 영역 끝-->

		<!-- 안테나 포트 영역 시작-->
		<section id="antenna">
			<div class="antenna-header">
				<div class="antenna-title">안테나 포트</div>
				<input type="text" id="antenna-port" class="antenna-port"
					value="100">
			</div>
			<div class="antenna-body">
				<ul class="antenna-result">
				</ul>

			</div>
		</section>
		<!-- 안테나 포트 영역 끝-->

		<!-- 입고 히스토리 영역 시작-->
		<section id="input-history">
			<div class="input-history-title">
				<span> 입고<br /> History
				</span>
			</div>
			<div class="input-history-content">
				<ul class="input-history-result">
				</ul>
				<!-- <div class="input-history-content-body">
				</div> -->
				<!-- <div class="input-history-content-footer">Total: 123개</div> -->
			</div>
		</section>
		<!-- 입고 히스토리 영역 끝-->

		<!-- 출고 히스토리 영역 시작-->
		<section id="output-history">
			<div class="output-history-title">
				<span> 출고<br /> History
				</span>
			</div>
			<div class="output-history-content">
				<ul class="output-history-result"></ul>
			</div>
			<!-- <div class="output-history-content">
				<ul class="output-history-content-body"></ul>
				<div class="output-history-content-footer">Total: 123개</div>
			</div> -->
		</section>
		<!-- 출고 히스토리 영역 끝-->

		<!-- 근로자 현황 영역 시작-->
		<!-- 		<section id="worker-history">
			<div class="worker-history-title">
				<span>근로자 현황</span>
			</div>
			<div class="worker-history-content">
			</div>
		</section> -->
		<!-- 근로자 현황 영역 끝-->

		<!-- 중복 태그 알림 영역 시작-->
		<!-- 		<section id="tag-alarm-history">
			<div class="tag-alarm-history-title">
				<span>중복 태그 알림</span>
			</div>
			<div class="tag-alarm-history-content">
			</div>
		</section> -->
		<!-- 중복 태그 알림 영역 끝-->
	</div>
	
	<%-- <c:import url="/WEB-INF/views/footer.jsp" /> --%>
</body>
</html>