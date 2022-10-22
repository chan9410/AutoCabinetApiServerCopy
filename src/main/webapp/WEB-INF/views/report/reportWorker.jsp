<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="/css/btn-style.css"></link>
<link rel="stylesheet" href="/css/report/reportWorker.css"></link>
<title>AutoCabinet</title>
</head>
<body>
	<c:import url="/WEB-INF/views/navbar.jsp" />

	<div class="report-worker-layout">
		<c:import url="/WEB-INF/views/report/reportSidebar.jsp" />
		<c:import url="/WEB-INF/views/report/reportWorkerContent.jsp" />
	</div>

	<%-- <c:import url="/WEB-INF/views/footer.jsp" /> --%>
</body>
</html>