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
	
</style>

</head>
<body>
	<h1>TO DO List</h1>

	<form class="doit" method="POST" action="${rootPath}/sub/insert">
		<input name="td_doit" placeholder="할 일을 입력한 후 Enter">
	</form>
	<table class="td_list">
		<c:forEach items="${TDLIST}" var="TD">
			<tr>
				<td>${TD.td_sdate}<br/>${TD.td_stime}</td>
				<td>${TD.td_doit}</td>
				<td>${TD.td_edate}<br/>${TD.td_etime}</td>
				
				
			</tr>
		</c:forEach>
	</table>
	
	
	
</body>
</html>