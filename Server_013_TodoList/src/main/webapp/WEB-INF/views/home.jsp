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
	
	h1, form.doit, table.td_list {
		width: 50%;
		margin: 10px auto;
		border-radius: 5px;
	}
	
	h1 {
		background-color: rgb(0, 255, 20, 0.3);
		color:white;
		padding: 1rem;
		text-align: center;
		/* text에 그림자 지정 */
		text-shadow: 1px 1px 1px #000;
	}
	
	form.doit{
		border: 1px solid rgb(0, 255, 20, 0.7);
		padding: 10px;
		tect-align: center;
	}
	
	form.doit input{
		width: 90%;
		/* input box를 클릭하면
		진한 box가 생기는 것을 방지*/
		outline: 0; 
		border: 1px solid #eee;
		border-radius: 5px;
		padding: 15px;
		margin: 10px;
		font-weight: bold;
	}
	
	form.doit input:hover{
		background-color: #eee;
	}
	
	table.td_list {
		border-collapse: collapse;
		border-spacing: 0;
	}
	
	table.td_list td {
		padding: 7px;
		border-top: 1px solid green;
		cursor: pointer;
	}
	/* table의 마지막 라인(tr)에 포함된 td 에만 */
	table.td_list tr:last-child td {
		border-bottom: 3px solid green;
	}
	
	table.td_list td.count {
		font-size: 20px;
		text-align: right;
		width: 5%;
		color: green;
	}
	
	table.td_list td.sdate, table.td_list td.edate {
		font-size: 10px;
		text-align: center;
		width: 20%;
	}
	
	table.td_list td.doit {
		font-size: 30px;
		text-align: left;
		
		/*
		두줄 이상의 본문을 1줄로 줄이고 말줄임표 표현
			table이 아닌 box 형 tag의 경우
				max-width 대신 width 값을 설정해야한다.
				아래 4가지 속성을 동시에 적용해야만 된다.
		*/
		max-width: 0;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
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
	<div class="msg">
		${ERROR}${COMP}
	</div>
	<table class="td_list">
		<c:forEach items="${TDLIST}" var="TD" 
					varStatus="ST">
			<tr>
				<td class="count">${ST.count}</td>
				<td class="sdate">${TD.td_sdate}<br/>${TD.td_stime}</td>
				<td class="doit">${TD.td_doit}</td>
				<td class="edate">${TD.td_edate}<br/>${TD.td_etime}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>