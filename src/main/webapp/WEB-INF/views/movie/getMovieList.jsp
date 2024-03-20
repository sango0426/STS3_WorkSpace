<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록 조회 결과</title>
<link rel="stylesheet" href="/resources/getMovieList.css">
</head>
<body>
	<div id="title">
		<h1>일별 영화 상세 정보 조회 결과</h1>
	</div>
	<div id="date">
		<h3>${searchDate}</h3>
	</div>
	<div id="list">
    <div class="category_title">
        <div id="search_date">영화 번호</div>
        <div id="movie_rank">영화 순위</div>
        <div id="movie_name">영화 이름</div>
        <div id="movie_open">영화 개봉일</div>
        <div id="movie_sales">영화 누적 매출액</div>
    </div>

    <c:forEach var="i" begin="0" end="${movieSize - 1}" step="1" >
        <div class="list_list">
            <div class="movie_num">${movieNum[i]}</div>
            <div class="movie_rank">${movieRank[i]}</div>
            <div>${movieName[i]}</div>
            <div>${movieOpen[i]}</div>
            <div>${movieSales[i]}</div>
        </div>
    </c:forEach>
</div>
</body>
</html>