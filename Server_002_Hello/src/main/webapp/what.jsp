<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// request���� ������ �Ű�����(Parameter)�� �޾Ƽ�
	// ������ ���ڿ� ���� name�� ��ƶ� 
	String name = request.getParameter("name");

	// 0 ~ 99���� ������ ������ ������ �����Ͽ�
	// ������ ���� num�� ��ƶ�
	int num = (int)(Math.random() * 100);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�ݰ����ϴ� <%= name %> ��</h1>
	<h3>������ ���� ? <%= num %></h3>
	
	<p>========================================</p>
	<p>7 ������ </p>
	<p>----------------------------------------</p>
	<%
	for(int i = 0; i < 9; i++){
		int num1 = i + 1;
		int dan = 7;
		int times = dan * num1;
	%>
		<p><%= dan %> x <%= num1 %> = <%= times %>

	<%
	}
	%>	



</body>
</html>