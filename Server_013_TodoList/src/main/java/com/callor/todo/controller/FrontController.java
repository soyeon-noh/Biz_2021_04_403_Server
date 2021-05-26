package com.callor.todo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.command.HomeCommandImplV1;
import com.callor.todo.command.TodoCommand;
import com.callor.todo.command.TodoCommandImplV1;

@WebServlet("/")
public class FrontController extends HttpServlet{

	protected Map<String, TodoCommand> commands; // Map ctrl+spacebar 해서 먼저 import해야 자동완성됨
	
	// FrontController가 최초 호출될 때 
	// 한번 실행되어서 
	// 여러가지 변수 등을 초기화 하는 코드
	@Override
	public void init(ServletConfig config) throws ServletException {
		commands = new HashMap<String,TodoCommand>();
		
		// key 값 : "/", HomeCommandV1의 객체를 포함하는
		
		/*
		 * 만약 http://localhost:8080/todo/ 로
		 * 요청이오면
		 * HomeCommandImplV1 객체를 사용하여
		 * 요청을 처리하기 위한 준비
		 */
		commands.put("/", new HomeCommandImplV1()); // 대리자등록 : homeCommandImpl에게 시키겠다!
		
		/* 만약 http://localhost:8080/todo/insert 로
		 * 요청이오면
		 * TodoCommandImplV1 객체를 사용하여
		 * 요청을 처리하기 위한 준비
		 */
		commands.put("/insert", new TodoCommandImplV1());
	}
	
	// doGet(), doPost()로 분리하여 요청을 처리하던 방식을 
	// 한개의 method에서 동시에 처리하기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Web에서 요청한 path 가져오기 
		String urlPath = req.getRequestURI();
		String path = urlPath.substring(req.getContextPath().length());
		
		// req 된 URI 중에서
		// 실제 subPath 부분을 사용하여
		// 처리할 객체를 Map으로부터 추출하기
		TodoCommand subCommand = commands.get(path); //command로 부터 객체를 추출하는거다?
		if(subCommand != null) {
			// 각 Command 객체의 execute() method에게
			// 실제 요청을 처리하도록 위임하는 것
			subCommand.execute(req, resp); //실제로 실행
			
		}
	}

	
}