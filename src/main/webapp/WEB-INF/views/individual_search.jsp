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
<link rel="stylesheet" href="/css/individual_search.css"></link>
<link rel="stylesheet"
	href="https://uicdn.toast.com/grid/latest/tui-grid.css" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.1/xlsx.full.min.js"></script>
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>

<script defer type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<script defer type="text/javascript" src="/js/individual_search.js"></script>


<title>Individual_search</title>
</head>
<body>
	<c:import url="/WEB-INF/views/navbar.jsp" />

	<div class=searchForm>

		<div class="title_div">
			<p class="title_text">제품 개별 검색</p>
			<div class="notice_div">
				<p class="notice_text">
					- 제품명 입력란에 찾고자하는 제품을 입력해주세요.<br />
					<br /> - 입력버튼을 누르면 검색한 리스트가 나옵니다.<br />
					<br /> - 찾고자하는 제품들을 체크하고 추가해주세요.
				</p>
			</div>
		</div>
		<div class="search_div">

			<div class="search_input_div">
				<a class="search_input_title">제품명</a>&nbsp;&nbsp; <input
					type="text" id="search_item_code" class="search_input_code" /> <input
					type="button" id="check_btn" class="check_btn" value="검색" />
			</div>

			<div id="grid"></div>

		</div>
		<input type="button" id="add_btn" class="add_btn" value="추가" />
		<div class="check_search_div">

			<div id="grid_second"></div>

		</div>
		<input type="button" id="del_btn" class="del_btn" value="삭제" />

		<div class="select_reset_btn_div">
			<input type="button" id="select_btn" class="select_btn" value="찾기"
				onclick="sendData()" /> <input type="button" id="reset_btn"
				class="reset_btn" value="초기화" />
		</div>

	</div>

	<c:import url="/WEB-INF/views/footer.jsp" />

</body>
</html>