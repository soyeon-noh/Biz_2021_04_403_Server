package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.config.DBInfo;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;

// localhost:8080/todo/sub/* 요청하기
@WebServlet("/sub/*")
public class TodoController extends HttpServlet{

	protected TodoService tdService;
	public TodoController() {
		tdService = new TodoServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String strSeq = req.getParameter("seq"); // seq 값 받아서
		Long td_seq = Long.valueOf(strSeq);
		
		Map<String,Object> tdVO = tdService.findById(td_seq); // 받은 seq 값으로 검색해서 추출
		System.out.println(tdVO.toString());
		
		Object td_edate = tdVO.get(DBInfo.td_edate);
		if(td_edate == null  // 완료날짜가 없으면 현재날짜로 셋팅해라
				|| String.valueOf(td_edate).equals("")) { // "" 이거없으면 Null됨...
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
			
			String edate = sd.format(date);
			String etime = st.format(date);
			
			tdVO.put(DBInfo.td_edate, edate);
			tdVO.put(DBInfo.td_etime, etime);
		} else {
			tdVO.put(DBInfo.td_edate, null);
			tdVO.put(DBInfo.td_etime, null);
		}
		System.out.println("여기냐?" + tdVO.toString());
		
		tdService.update(tdVO);
		
		resp.sendRedirect(req.getContextPath());
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String td_doit 
			= req.getParameter(DBInfo.td_doit);
		
		// Map type의 VO 선언하기
		Map<String,Object> tdVO 
			= new HashMap<String, Object>();
		tdVO.put(DBInfo.td_doit, td_doit);
		tdService.insert(tdVO);
		
		// 처음화면으로 jump 
		// request.getContextPath() : 프로젝트 Path만 가져온다.
		// http://localhost:8080/todo/sub/insert 인 경우
		// 						/todo 를 가져온다.	
		resp.sendRedirect(req.getContextPath());
	}

	
}
