package com.callor.diet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.service.FoodService;
import com.callor.diet.service.impl.FoodServiceImplV1;

@WebServlet("/food/*")
public class FoodController extends HttpServlet{
	private static final long serialVersionUID = 5430871336219122803L;
	protected FoodService fdService;
	
	public FoodController() {
		fdService = new FoodServiceImplV1();
	}
	
	// anchor link를 클릭했을 때 처리할 method
	// a tag : <a href>
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청주소에 /food 다음에 오는 sub
		//			요청문자열을 추출
		// /food/search 라고 요청을 보내면 
		//			/search 문자열 추출
		String subPath = req.getPathInfo();
		
		if(subPath == null || subPath.equals("")) {
			System.out.println("요청 subPath 없음");
			
		}else if (subPath.equals("/search")) {
			
			 //ReqController에서 생성으로 인해 코드를 사용할 수 잇음
	         //식품검색 화면 보여주기
	         ReqController.forward(req, resp, "search"); // 오타를 방지하기 위한 Req 메서드 사용
		}
	}

	// form에서 input Box에 입력한 데이터를 전송했을 때
	// method를 POST로 지정하면 처리하는 함수
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//req.setCharacterEncoding("UTF-8"); // 컨트롤러에 한글! 
		// 이거 대신할 KoreaFilter 만들었음
		
		
		String subPath = req.getPathInfo();
		
		if(subPath == null || subPath.equals("")) {
			System.out.println("요청 subPath가 없음");
		} else if(subPath.equals("/search")) {
			
			// form에 입력된 데이터를 
			//		추출(파라메터를 Get)하고
			String f_name = req.getParameter("f_name");
			
			// DB에서 조회하여 다시 Web에 보여주기
			List<FoodDTO> foodList 
				= fdService.findByFName(f_name);
			req.setAttribute("FOODS", foodList);
			ReqController.forward(req, resp, "search");
		}
	}
	
	
	
	
}
