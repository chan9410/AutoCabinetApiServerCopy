<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/css/btn-style.css"></link>
<link rel="stylesheet" href="/css/report/reportWorkerContent.css"></link>
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.1/xlsx.full.min.js"></script>
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<script defer type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<script defer type="text/javascript" src="/js/report/reportWorkerContent.js"></script>

<section id="report-worker-content">
	<section id="report-worker-content-top">
		<div class="report-worker-content-top-left">
			<label for="worker-id"> 근로자 성명 </label> <input id="worker-id"
				type="text" />

		</div>
		<div class="report-worker-content-top-center">
			<span> 기간 설정 </span> <input id="from-date" type="date" /> ~ <input
				id="to-date" type="date" />
		</div>
		<div class="report-worker-content-top-right">
			<button id="search-btn" class="common-btn">검색</button>
		</div>
	</section>
	<section id="report-worker-content-bottom">
	
	<div id = "grid"></div>
	
	</section>
</section>