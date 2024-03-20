<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 게시판 - 글쓰기</title>
<link rel="stylesheet" href="/resources/write.css">
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
		<form id="form_wrapper" action="/guest/write" method="post">	<!-- todo: http://localhost:8080/guest/write 부분 해결 -->
			<div id="wrapper_body">
				<input id="wrapper_body_title" name="btitle" placeholder="제목">
				<textarea rows="3" name='btext' placeholder="내용"></textarea>
			</div>
			<div id="wrapper_bottom">
				<input type="submit" value="글쓰기">
			</div>
		</form>
	</div>
</body>
</html>