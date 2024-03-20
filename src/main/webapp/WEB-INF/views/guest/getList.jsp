<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.dto.GuestDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 0. 웹 애플리케이션의 루트 경로(컨텍스트 경로) 를 가져와서 링크에 다 연결해줘야 함     -->
<!-- 1. 0을 위한 준비. jstl core 태그 선언     -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 2. 0을 위한 준비. el 태그로 가져올 수 있는데 이걸 더 짧게 찍기위해 변수 대입함.     -->    
<c:set var="cp" value="${pageContext.request.contextPath}" />    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 게시판 - 리스트</title>
<link rel="stylesheet" href="/resources/getList.css" >
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
		<div id="wrapper_body">
			<div id="wrapper_body_top">
				<div id="body_top_num">번호</div>
				<div id="body_top_title">제목</div>
			</div>
			<div id="body_list">
			<%
			Object o = request.getAttribute("list");
			List<GuestDto> list = (List<GuestDto>)o; 
			for(int i=0;i<list.size();i++){
				Long bno = list.get(i).getBno();
				String btitle = list.get(i).getBtitle();
			%>	
				<div class="body_item">
                    <div id="body_list_num">
                        <%=bno %>
                    </div>
                    <div id="body_list_title">
                        <a href="read?bno=<%=bno%>">
                            <%=btitle %>
                        </a>
                    </div>
                </div>
			<%
			}
			%>
			</div>
		</div>
		<div id="bottom">
			<div id="wrapper_bottom">
				<a href="/guest/write"><button>글쓰기</button></a>
			</div>
			<div id="pagingNum">
				<c:if test="${hasPrev == true}" >
					[<a href="${cp}/guest/getList?page=${prevPage}"><b>이전</b></a>]
				</c:if>

				<c:forEach var="p" begin="${blockStartNo}" end="${blockEndNo}">
					[<a href="${cp}/guest/getList?page=${p}">${p}</a>]
				</c:forEach>
	
				<c:if test="${hasNext == true}" >
					[<a href="${cp}/guest/getList?page=${nextPage}"><b>다음</b></a>]
				</c:if>

				<fieldset>
					<legend>게시판 정보</legend>
					전체 글 수:${totalCount} <br>
					전체 페이지수:${totalPage} <br>
					전체 블럭 수:${totalBlock}<br>
					<hr>
					현재 블럭 번호:${currentBlock}<br>
					현재 블럭 시작 번호:${blockStartNo}<br>
					현재 블럭 끝 번호:${blockEndNo}<br>
					이전 블럭 가기 가능 여부:${hasPrev}<br>
					다음 블럭 가기 가능 여부:${hasNext}<br>
					이전 블럭 이동 시 이동 될 페이지:${prevPage}<br>
					다음 블럭 이동 시 이동 될 페이지:${nextPage}<br>
				</fieldset>
			</div>
			<div id="search">
				<form action="/guest/getList">
					<div id="search_text">
						<input name="word" placeholder="검색할 내용 입력하기">
						<input type="submit" value="검색하기">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>