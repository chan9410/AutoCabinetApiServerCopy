<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="/css/btn-style.css"></link>
<link rel="stylesheet" href="/css/group_search.css"></link>

<script defer type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<script defer type="text/javascript" src="/js/group_search.js"></script>


<title>Group_search</title>
</head>
<body>
	<c:import url="/WEB-INF/views/navbar.jsp" />

	<div class=searchForm>

		<div class=title_div>
			<p class="title_text">품목 검색</p>
			<div class="notice_div">
				<p class="notice_text">
					- 제품명 입력란에 찾고자하는 제품군을 입력해주세요.<br />
					<br /> - 입력버튼을 누르면 검색한 제품항목이 내려갑니다.<br />
					<br /> - 입고일을 특정하고 싶지 않다면, 모든 날짜를 체크해주세요.
				</p>
			</div>
		</div>
		<div class="search_div_code">

			<div class="search_input_div">

				<a class="a_input_title">제품명</a>&nbsp;&nbsp;
				 
				<input type="text" class="search_input" /> 
				<input type="button" class="check_btn" value="검색" />

			</div>
			<div class="search_datas_div">
				<div class="search_input_datas"></div>
			</div>

		</div>

		<div class="search_div_date">
			<div class="input_date_div">
				<a class="a_input_date">입고일</a>&nbsp;&nbsp; 
				<input type="date" id = "inputStartDate" class="input_date" />&nbsp;<a class = "tilde">~</a>&nbsp;
				<input type="date" id = "inputLastDate" class="input_date" /> &nbsp;&nbsp; 
				<!-- <input type="checkbox" id="total_date_check" />
				<a class="total_date_ckbox">모든 날짜</a> -->
			</div>
		</div>

		<div class="select_reset_btn_div">
			<input type="button" class="select_btn" value="찾기" /> <input
				type="button" class="reset_btn" value="초기화" />
		</div>

	</div>

	<c:import url="/WEB-INF/views/footer.jsp" />
</body>
</html>