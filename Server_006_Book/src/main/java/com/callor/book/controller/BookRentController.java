package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.service.BookRentService;
import com.callor.book.service.impl.BookRentServiceImplV1;

/*
 * Web Browser의 Request를 처리할 클래스로 만들기 위해서
 * 
 */

@WebServlet("/rent/*")
public class BookRentController extends HttpServlet{


	private static final long serialVersionUID = 921652892464670154L;
	
	protected BookRentService brService;
	public BookRentController() {
		brService = new BookRentServiceImplV1(); // new... 추가하기
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subPath = req.getPathInfo(); // /rent/* 이거 뒤에 오는 별
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(subPath.equals("/list")) {
			// 도서대여 전체 목록
			out.println("도서대여 전체목록 보기");
			brService.selectAll();
			
		} else if(subPath.equals("/seq")) {
			// 주문 번호로 찾기
			String strSeq = req.getParameter("id");
			Long nSeq = Long.valueOf(strSeq);
			BookRentDTO brDTO = brService.findById(nSeq);
			
			// view에서 보여줄 데이터 생성
			ServletContext app = this.getServletContext();
			
			// bService가 return한 brDTO를 
			// app 객체에 BOOK 이라는 속성변수로 세팅하기
			app.setAttribute("BOOK", brDTO);
			
			// book.jsp 파일을 읽어서
			// app에 setting한 BOOK 변수와 함께
			// Rendering을 하라
				// ★ Rendering : 
				//	 여기 컨트롤러에서 BOOK이라는 변수에 담아서 book.jsp에 이 코드를 보낸다.
				//	 그러면 book.jsp는 ${BOOK.br_isbn} 이런 코드에 담는 거임
				//	 톰켓이 하는 일이다.)
			RequestDispatcher disp			// 사용자가 요청한 결과를 ()경로에 보내라
			= app.getRequestDispatcher("/WEB-INF/views/book.jsp"); 

			
			// Rendering 된 view 데이터를
			// Web browser로 response 하라
			disp.forward(req, resp);
			
			
		} else if(subPath.equals("/isbn")) {
			// 도서 코드로 찾기
			brService.findByBISBN("ibsn");
			
		} else if(subPath.equals("/buyer")) {
			// 회원 코드로 찾기
			brService.findByBuyerCode("buyercode");
			
		} else if(subPath.equals("/rent")) {
			// 대여정보 추가, 대여하기
			BookRentVO bookRentVO = new BookRentVO();
			brService.insert(bookRentVO);
			
		} else if(subPath.equals("/return")) {
			// 반납하기
			BookRentVO bookRentVO = new BookRentVO();
			brService.update(bookRentVO);
			
		} else {
			// 더이상 그만하기
		}
	}
	
}
