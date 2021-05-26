<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
			prefix="c"%>
<c:set value="${pageContext.request.contextPath}" 
		var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY TODO List</title>

<style>
	/* style 지정을 위하여 전체 초기화 */
	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	
	h1, form.doit {
		width: 50%;
		margin: 10px auto;
		border-radius: 5px;
	}
	
	h1 {
		background-color: rgb(0, 255, 0, 0.3);
		color:white;
		padding: 1rem;
		text-align: center;
	}
	
	form.doit{
		border: 1px solid red;
		padding: 10px;
		tect-align: center;
	}
	
	
</style>

</head>
<body>
	<h1>TO DO List</h1>

		<%--
		form tag의 action 속성
		form tag의 action 속성은 form에 담긴 데이터를 
		submit 할 때 (서버로 전송할 때)
		어떤 uri path를 통해서 서버에 보낼 것인가를 지정하는 것
		
		만약 이 action 속성을 지정하지 않으면 
		현재 파일(home.jsp)을 보여줄 때 사용한
		uri 주소가 자동으로 설정되어 있다.
		
		${rootPath}/ 처럼 주소를 지정하는 것
		
		form, a tag 등에 URL, URI 를 지정할 때
		주소의 지정방식에따라 상대주소, 절대주소 방식이 있다.
		그러나 지정하는 방법에 따라 연결이 잘 안되는 경우가 많다.
		
		우리 프로젝트는 모두 절대주소 지정방식으로 통일하고
		항상 주소(URI, URL)과 관련된 모든 항목은
		${rootPath}로 시작하는 주소로 사용한다
		( rootPath = http://localhost:8080/todo )
		 --%>

	<form class="doit" method="POST" action="${rootPath}/insert">
		<input name="td_doit" placeholder="할 일을 입력한 후 Enter">
	</form>

	
	
	
</body>
</html>