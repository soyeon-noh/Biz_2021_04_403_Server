<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- HTML 주석:  Web Source 보기로 하면 노출되는 주석 -->
<%-- 
	JSP 주석 : Source 보기로 노출되지 않음
				HTML 주석보다는 다소 자유롭게 작성가능
 --%>
 
 <%--
 	standard TagLib
 	HTML에서 지원하지 않는 기능을 수행하기 위하여
 	JSP 파일에서 사용하는 확장된 tag 기능
 	Controller에서 List, 배열에 데이터를 담아 보내면
 	단순한 HTML, EL tag만으로는 보여주기가 매우 어렵다.
 	이러한 데이터를 다소 쉽게 표현하기 위한 도구
 	
 	JSTL : JSP Standard Tag Lib
 			JSP 2.0 이상에서 사용가능, Tomcat 5.5 이상에서 사용가능
 	Tomcat 5.5 는 2006년부터 사용하는 Tomcat
 	
  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%-- 저 uri를 c라고 줄여부르겠다 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 조회결과</h1>
	<c:if test="${empty BUYERS }">회원정보 없음</c:if>
	<%--
	for(BuyerDTO d : buList){
	
	BUYERS -> List 담겨있는값
	BUYER -> D..?
	 --%>
	
	<c:forEach items="${BUYERS }" var="BUYER">
		<p>${BUYER.bu_code},
			<a href="page2?bu_code=${BUYER.bu_code}">
			${BUYER.bu_name}</a>,
			${BUYER.bu_tel},
			${BUYER.bu_addr}
	</c:forEach>	
</body>
</html>