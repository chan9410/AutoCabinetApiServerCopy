<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="now" value="<%=new java.util.Date()%>" />
<link rel="stylesheet" href="/css/btn-style.css"></link>
<link rel="stylesheet" href="/css/report/reportMainContent.css"></link>
<link rel="stylesheet"
	href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script defer
	src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
<script defer src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<script defer src="/js/report/reportMainContent.js"></script>

<section id="report-main-content">

	<!-- 현황 정보 시작 -->
	<section id="report-info">
		<%-- <div class="report-total-stock-info-header">
			<span> <fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />
			</span>
		</div> --%>

		<div class="report-info-top">
			<div class="report-info-top-left">
				<select class="report-device-list">
					<option value="0">전체 디바이스</option>
				</select>
			</div>
			<div class="report-info-top-right">
				<div class="search-time-container">
					<input type="date" id="from-date" /> ~ <input type="date"
						id="to-date" />
				</div>
				<button id="search-btn" type="button" class="common-btn">검색</button>
			</div>
		</div>
		<div class="report-info-bottom">
			<div class="report-info-card stock">
				<div class="report-info-card-top stock">최근 재고 현황</div>
				<div id="stock-count" class="report-info-card-bottom">0</div>
			</div>
			<div class="report-info-card input">
				<div class="report-info-card-top input">최근 입고 현황</div>
				<div id="input-count" class="report-info-card-bottom">0</div>
			</div>
			<div class="report-info-card output">
				<div class="report-info-card-top output">최근 출고 현황</div>
				<div id="output-count" class="report-info-card-bottom">0</div>
			</div>

		</div>

	</section>
	<!-- 현황 정보 끝 -->

	<!-- 차트 시작 -->
	<section id="report-stock-chart">
		<canvas id="total-stock-chart" width=2000 height=300></canvas>
	</section>
	<!-- 차트 끝 -->

	<!-- 재고 그리드 시작 -->
	<section id="report-stock-grid"></section>
	<!-- 재고 그리드 끝 -->

	<!-- 입고 그리드 시작 -->
	<section id="report-input-grid"></section>
	<!-- 입고 그리드 끝 -->

	<!-- 출고 그리드 시작 -->
	<section id="report-output-grid"></section>
	<!-- 출고 그리드 끝 -->

</section>