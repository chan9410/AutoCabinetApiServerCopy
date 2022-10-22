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
<link rel="stylesheet" href="/css/item_regist_history.css"></link>
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css"/>
  
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.1/xlsx.full.min.js"></script>
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>

<script defer type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<script defer type="text/javascript" src="/js/item_regist_history.js"></script>


<title>item_regist_history</title>
</head>
<body>
	<c:import url="/WEB-INF/views/navbar.jsp" />

	<div class = searchForm>
	
	<div class = "search_div">
	<p class = "title_text">물품 등록 현황</p>
	<div class = "search_content_div">
	<p class = "sub_text">등록 기준일</p>
	<input type = "date" class = "registStartDate"/>&nbsp;<a class = "tilde">~</a>&nbsp;
	<input type = "date" class = "registLastDate"/>&nbsp;&nbsp;
	
	<p class = "sub_text">항목</p>
	<input type = "text" class = "check_category"/>
	
	<input type = "text" class = "check_category_text"/>
	
	<input type = "button" class = "search_btn" value = "검색"/>
	</div>
	</div>
	
		<div id = "grid"></div>
	
			
	<div class = "select_reset_btn_div">
	<input type = "button" class = upload_btn value = "등록"/>
	</div>
	</div>
	
	<%-- <c:import url="/WEB-INF/views/footer.jsp" /> --%>

</body>
</html>