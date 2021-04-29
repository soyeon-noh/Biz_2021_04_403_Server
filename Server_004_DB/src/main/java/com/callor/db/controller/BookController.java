package com.callor.db.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.db.model.BookVO;
import com.callor.db.service.BookService;
import com.callor.db.service.impl.BookServiceImplV1;

// new -> Servlet 만들기로 만들어도 되는데 수동으로 만들어보자!

// localhost:8080/db/book(URI) 이라고 요청하면 
// localhost:8080 = Tomcat을 호출하는 부분 URL
// /db : ContextRoot = 프로젝트의 별명
// /book : 요청path 
// ?변수=값 : Query 요청 값

@WebServlet("/book/*")
public class BookController extends HttpServlet {
	
	private BookService bService;
	
	public BookController() {
		bService = new BookServiceImplV1();
	}
	
	/*
	 * WAS 관련 프로젝트를 수행할때
	 * 클래스를 만들고 서버를 한번 Run 한 후에
	 * 다시 클래스 코드를 변경하면 
	 * Tomcat이 자동으로 재시작된다
	 * 그때 Tomcat이 내부적으로 클래스의 정보를 참조하는
	 * 일종의 Key값이다.
	 */
	private static final long serialVersionUID = 1L; // 없어도 있어도 상관없다. 

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * db/book/* 의 pattern 으로 요청을 하면
		 * * 부분에 추가된 sub Path를 추출하여 여러가지 요청을
		 * 처리할 수 있다.
		 * 이때 추가된 sub Path를 추출할때는 req.getPathInfo()를
		 * 사용하여 추출한다
		 */
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String subPath = req.getPathInfo();
		
		if(subPath.equals("/select")) {
			List<BookVO> bookList = bService.selectAll();
			out.println(bookList.toString());
			
		} else if(subPath.equals("/find")) {
			
			String isbn = req.getParameter("isbn");
			BookVO bookVO = bService.findById(isbn);
			
			if(bookVO == null) {
				out.println("찾는 데이터가 없음");
			} else {
				out.println(bookVO.toString());
			}
		}
		
		out.println(subPath);
		out.close();

	} // end doGet()
	
	private void selectAll() {
		List<BookVO> bookList = bService.selectAll();
		//resp.setContentType("text/html;charset=UTF-8");
		
		//Integer.valueOf("A0001"); // 서버에 일부러 문제를 만들기 500번오류 생김
		
		PrintWriter out = null; //resp.getWriter();
		out.println("Welcome to my home :");
		//out.println(req.getContextPath());
		
		for(BookVO vo : bookList) {
			out.print("<p>");
			out.print(vo.getBk_isbn());
			out.print(vo.getBk_title());
			out.print(vo.getBk_ccode());
			out.print(vo.getBk_acode());
			out.print(vo.getBk_price());
			out.print(vo.getBk_pages());
			out.println(vo.getBk_date());
		}
		out.print(false);
		
		out.close();
	}
	
	private void callService() {
		
		BookVO bookVO = new BookVO();
		bookVO.setBk_title("자바입문");
		bookVO.setBk_ccode("C0001");
		bookVO.setBk_acode("A0001");


		// 데이터추가
		bService.insert(bookVO);
		// 전체리스트
		List<BookVO> bookList = bService.selectAll();
		
		// 도서 1개 정보 조회
		BookVO retVO = bService.findById("97000000");
		
		// 도서정보 변경
		bService.udate(bookVO);
		
		// 도서정보 데이터 1개 삭제
		bService.delete("97000000");
	}
}
