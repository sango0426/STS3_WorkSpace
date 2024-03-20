<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전적 검색 결과!</title>
<link rel="stylesheet" href="/resources/recordSearch.css">
</head>
<body>
	<div id="wrapper">
		<div id="wrapper_top">
			<div id="top_title">
				<h2>${userName}님의 전적 검색 결과</h2>
			</div>
		</div>
		<div id="wrapper_mid">
			<div id="record_list">
				<div id="record_userName">소환사 이름 : ${userName}</div>
				<div id="record_userLevel">소환사 레벨 : ${userLevel}</div>
				<div id="record_userTier">티어 : ${userTier}</div>
				<div id="record_userRank">랭크 : ${userRank}</div>
				<div id="record_userWins">승리 : ${userWins}</div>
				<div id="record_userLosses">패배 : ${userLosses}</div>
			</div>
		</div>
		<div id="wrapper_bottom">
			<div id="bottom_button">
				<a href="/"><button>이전으로</button></a>
			</div>
		</div>
	</div>
</body>
</html>