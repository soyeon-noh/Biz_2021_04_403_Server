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
<meta name="viewport" content="width=device-width, initial-scale=1.0" /> <%-- 이게없어서 @media 적용안됨 --%>
<title>MY TODO List</title>

<style>
	/* style 지정을 위하여 전체 초기화 */
	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	
	h1, form.doit, table.td_list{
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
		/*
		table에 각 td와 td의 간격에 미세하게 여백이 있다.
		가끔 선을 그리면 선과 선 사이에 틈새가 보인다.
		이러한 틈새를 막기위해 설정하는 값.
		*/
		border-spacing: 0px;
	}

	table.td_list td {
		padding: 7px;
		border-top: 1px solid green;
		cursor: pointer;
	}
	
	/* table의 가장 마지막 tr(line)의 칼럼들에게만 적용 */
	table.td_list tr:last-child td {
		border-bottom: 1px solid green;
	}
	
	table.td_list td.sdate, table.td_list td.edate {
		font-size: 10px;
		text-align: center;
		width: 20%;
	}

	/*
		width : 무조건 폭을 지정
		max-width : 포함된 text(content)길이에 따라 조절을 하되
					최소 크기만 제한
	*/	
	table.td_list td.doit {
		font-size: 30px;
		text-align: left;

		max-width: 80%; /* 의미x */
		/*
		td의 width 보다 큰 text를 말줄임표로 표현하기
		
		td가 3개인데
		첫번째, 세번째 td를 20%로 설정했기 때문에
		여기 td는 전체 table width의 60%가 될 것이다.
		이 상태에서 max-width를 0으로 지정하고
		ellipsis 설정을 해주면 된다.
		*/
		
		/* 최대 width 보다 textr가 더 많더라도
			자동으로 줄바꿈 하지 않기
		*/
		max-width: 0;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
	}
	
	table.td_list tr:hover {
		background-color: #eee;
	}
	
	.underline {
		 text-decoration: 3px underline red dashed;
	}
	
	.text-throth {
		 text-decoration: 3px line-through red wavy;
	}
	
	/*
	media query
	반응형 web에서 사용하는 CSS 기법
	
	screen 이라는건 안써도 된다지만 성능이 떨어진다고... 한다
	media 쿼리를 시작하겠다 screen(화면)에서만. 이라는 뜻!

	max-width : 화면폭이 이 값보다 작으면
	min-width : 화면폭이 이 값보다 크면	
	*/
	@media screen and (max-width: 800px){
		h1, form.doit, table.td_list{
			width: 95%; /* 반응형만들 땐 width는 %로 지정한다 */
			margin: 5px auto;
		}
		
		h1 {
			font-size: 10px;
		}
		
		form.doit {
			background-color: blue;
		}
	}
	
</style>
<script>
// script가 어디에 위치하든 상관없이
// 		Event가 정상적으로 설정될 수 있도록 선언
// 화면에 DOM 요소가 모두 완전하게 나타나면
// 		내부의 코드를 실행하라.
document.addEventListener("DOMContentLoaded",()=>{
	// ()=>{  } : 화살표 함수
	// function() {  } : 이것과 같다
	document.querySelector("table.td_list")
	.addEventListener("dblclick",(ev)=>{
		// table의 TD 항목이 클릭되었을때만 반응하기 위해
		let tagName = ev.target.tagName
		if(tagName == "TD"){
			// 방금 더블클릭된 TD를 감싸고 있는 TR의
			let seq = ev.target.closest("TR")
					.dataset.seq;
			let edate = ev.target.closest("TR")
					.dataset.edate;			
			
			let msg = edate ? "TODO 완료를 취소합니다" 
						: "TODO 를 완료처리 합니다";
				
			if(confirm(msg)){
				location.href="${rootPath}/sub/expire?seq=" + seq;
			}
		}
	})
})
</script>

</head>
<body>
	<h1>TO DO List</h1>

	<form class="doit" method="POST" action="${rootPath}/sub/insert">
		<input name="td_doit" placeholder="할 일을 입력한 후 Enter">
	</form>
	<table class="td_list">
		<c:forEach items="${TDLIST}" var="TD">
			<%-- data set 설정하기--%>
			<tr data-seq="${TD.td_seq}" data-edate="${TD.td_edate}">
				<td class="sdate ${empty TD.td_edate ? '' : 'underline' }">${TD.td_sdate}<br/>${TD.td_stime}</td>
				<td class="doit ${empty TD.td_edate ? '' : 'text-throth' }">${TD.td_doit}</td>
				<td class="edate">${TD.td_edate}<br/>${TD.td_etime}</td>
				
				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>