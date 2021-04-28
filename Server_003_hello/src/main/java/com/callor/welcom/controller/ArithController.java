package com.callor.welcom.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class ArithController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String strNum1 = req.getParameter("num1");
		String strNum2 = req.getParameter("num2");
		
		Integer intNum1 = Integer.valueOf(strNum1);
		Integer intNum2 = Integer.valueOf(strNum2);
		
		Integer sum = intNum1 + intNum2;
		
		// webapp 폴더의 경로(path)가져오기 위한 객체
		ServletContext app = this.getServletContext();
		
		// 변수를 세팅하기 (num1변수를 만들어서 intNum1라는 값을 셋팅)
		app.setAttribute("num1", intNum1);
		app.setAttribute("num2", intNum2);
		app.setAttribute("sum", sum);
		
		
		// jsp 파일을 Randering을 강제로 수행하기
		// 왜 강제로 수행하는가! 
		// 랜더링을 직접실행하는 것
		RequestDispatcher dispatcher
		= app.getRequestDispatcher("/result.jsp"); // result.jsp랑 랜더링해라
		dispatcher.forward(req, resp);
		
		//옛날에는 (what.jsp) 
		// Controller로 java도 html도 만들어야했는데
		// 지금은 java따로 jsp따로 만들어서 (result.jsp)
		// java는 클래스에서 연산 하고
		// jsp는 보여주는 용도로만 만듬.. 이 둘을 랜더링해서
		// 디자이너 개발자 협업가능
		
	}
}
