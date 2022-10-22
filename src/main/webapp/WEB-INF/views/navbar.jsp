<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/css/reset.css"></link>
<link rel="stylesheet" href="/css/navbar.css"></link>
<nav class="navbar">
	<ul class="navbar-menu-container">
		<li class="navbar-menu-item"><a href="/">실시간 재고</a></li>
		<li class="navbar-menu-item"><a href="/report">보고서</a></li>
		<li class="navbar-menu-item"><a href="/item_regist">물품 등록</a></li>
		<li class="navbar-menu-item"><a href="/item_regist_history">물품 등록
				현황</a></li>
		<li class="navbar-menu-item"><a>서비스</a></li>
		<li class="navbar-menu-item"><a>사용자 관리</a></li>
		<li class="navbar-menu-item"><a>설정</a></li>
	</ul>

	<div class="navbar-user">
		<span> 김남중님 로그인하셨습니다. </span>

		<button class="navbar-btn">로그아웃</button>
	</div>

</nav>