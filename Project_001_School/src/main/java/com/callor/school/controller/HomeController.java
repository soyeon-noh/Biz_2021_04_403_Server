package com.callor.school.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.school.service.SchoolService;
import com.callor.school.service.impl.SchoolServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet{

	SchoolServiceImplV1 scService;
	
	public HomeController() {
		scService = new SchoolServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/WEB-INF/views/home.jsp")
		.forward(req, resp);
		
	}

	
}
