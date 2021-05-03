<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h5>ISBN : ${BOOK.br_isbn}</h5>
	<h5>도서명 : ${BOOK.br_title}</h5>
	<h5>회원코드 : ${BOOK.br_bcode}</h5>
	<h5>회원명 : ${BOOK.br_bname}</h5>
	<h5>회원연락처 : ${BOOK.br_tel}</h5>
	<h5>대여일 : ${BOOK.br_sdate}</h5>
	<h5>반납일 : ${BOOK.br_edate}</h5>
	<h5>대여료 : ${BOOK.br_price}</h5>
	
	
</body>
</html>