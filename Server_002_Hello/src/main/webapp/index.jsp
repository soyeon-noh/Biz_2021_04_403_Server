<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
int num1 = 10;
int num2 = 20;
int sum = num1 + num2;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP(Java Server Page)</h1>
	<h3><%= num1 %> + <%= num2 %> = <%= sum %></h3>
	<p>html ���Ͽ� java �ڵ带 ���ٿ��� java �ڵ����� �پ��� ����� 
	������ �� �ֵ��� ��ȵ� ���
	<p>1999�⿡ ź���� ���
	<p>PHP, ASP ��� ���� ������� ���ɶ� 
	java �����ڵ��� ���Ͽ� ź���� ���
	<p>PHP : C���� ����� �������� �� ���, ���¼ҽ�, 
	Linux �� �ü���� ������� ����� �� �ִ�.
	<p>ASP : Basic, C# ���� �� ����ϴ� MS���� ���� ���
	
	<h3>���� Web Page</h3>
	<p>�Ϲ������� �̹���, text ������ �����ε� HTML ������ ����Ͽ� 
	�ۼ��� Web ȭ��
	<p>*.html, *.htm �������� �ۼ��� ������ Response �ϴ� ���
	
	<h3>����(Dynamic, Interactive) Web Page</h3>
	<p>Client(Web Browser)���� ��û�ϴ� Request�� ����
	<p>�پ��� ������ �����ִ� ������ Response �ϴ� ���
	
	
	
</body>
</html>