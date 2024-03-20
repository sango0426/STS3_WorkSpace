<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/read.css">
</head>
<body>
	<div id="wrapper">
		<div id="wrapper_top">
			<div id="wrapper_top_logo">
				<a href="/"><img src="/resources/tarkovlogo.jpg"></a>
			</div>
			<div id="wrapper_top_advertisement">
				<a href="https://liesofp.inven.co.kr/"><img src="/resources/advertisement.jpg"></a>
			</div>
			<div id="wrapper_top_login">
				<a href=""><button>로그인</button></a>
				<a href=""><button>회원가입</button></a>
			</div>
		</div>
		<div id="wrapper_body_post">
			<div id="body_post_num">${read.bno}번글 : ${read.btitle}</div>
			<hr>
			<div id="body_post_text">${read.btext}</div>
		</div>
		<div id="wrapper_body_bottom">
			<div id="body_bottom_del">
				<a href="/guest/del?bno=${read.bno}">삭제</a>
			</div>
			<div id="body_bottom_modify">
				<a href="/guest/modify?bno=${read.bno}">수정</a>
			</div>
			<div id="body_bottom_toList">
				<a href="/guest/getList">리스트로</a>
			</div>
		</div>
	</div>
</body>
</html>