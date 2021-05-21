package com.callor.guest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestForwardController {
// 반복적으로 하는 
	
	private final static String prefix = "/WEB-INF/views/"; // view 파일이 저장되어 있는 폴더
	private final static String surfix = ".jsp";
	
	public static void forword(
			HttpServletRequest req, 
			HttpServletResponse resp, 
			String file) throws ServletException, IOException {
		
		String viewFile = prefix + file + surfix;
		
		req
		.getRequestDispatcher(viewFile)
		.forward(req, resp); // add throws
	}
}
