package com.callor.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/") // root로 만들기
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = -953531494441799347L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서버를 처음 run했을때 최초로 보여지는 화면설정 (MVC 패턴)
		
//		req.getRequestDispatcher("/WEB-INF/views/home.jsp")
//		.forward(req, resp);
		
		ReqController.forward(req, resp, "home"); // 오타를 방지하기위한 Req 메서드 사용
		
		
	}

	
}
