package com.callor.welcom.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/soyeon")
public class TechController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1 style='background-color:#F1DAC8'>나나언니 신나보이네</h1>");
		out.println("<h1 style='color:red'>수업언제끝나냐</h1>");
		out.println("<h2 style='color:orange'>은결이 부럽다 집가서</h2>");
		out.println("<h2 style='color:green'>영진이도 부러운걸로</h2>");
		out.println("<img src='/puppy-1903313_1920.jpg' alt='이미지가 없나봐요..'>");
		out.print("<a href='");
		out.print("http://localhost");
		out.print(":8080");
		out.print("/welcome/home'>");
		out.println("홈으로</a>");
		out.print("<a href='");
		out.print("http://localhost");
		out.print(":8080");
		out.print("/welcome/book'>");
		out.println("Book으로</a>");
		out.close();
	}

	
}
