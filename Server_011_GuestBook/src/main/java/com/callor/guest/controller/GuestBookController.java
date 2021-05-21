package com.callor.guest.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.guest.config.DbInfo;
import com.callor.guest.model.GuestBookVO;
import com.callor.guest.service.GuestBookService;
import com.callor.guest.service.impl.GuestBookServiceImplV1;

@WebServlet("/guest/*") // *로 끝나는 경우 subPath를 뽑아낼 수 있다.
public class GuestBookController extends HttpServlet{
	
	protected GuestBookService gbService;
	public GuestBookController() {
		gbService = new GuestBookServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		if(subPath.equals("/view")) {
			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);
			GuestBookVO gbVO = gbService.findById(gb_seq);
			
			req.setAttribute("GB", gbVO);
			
			// Command 패턴
			// Delgate(대리자) 패턴
			// req.forword()를 다른 Class에게 일임하기
			RequestForwardController.forword(req, resp, "view");
			
//			req.getRequestDispatcher("/WEB-INF/views/view.jsp")
//			.forward(req, resp);
		} else if (subPath.equals("/insert")) {
			
			GuestBookVO gbVO = new GuestBookVO();
			
			
			// 글쓰기를 시작할 때 자동으로
			// 현재 날짜와 시각을 만들어주기
			// java 1.7이하에서도 모두 사용할 수 있는 방법
			SimpleDateFormat sd  // 날짜
				= new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat st  // 시간
				= new SimpleDateFormat("HH:mm:ss");
			Date date 
				= new Date(System.currentTimeMillis());
			
			gbVO.setGb_seq(0L);
			gbVO.setGb_date(sd.format(date)); // 날짜를 문자열로 변환
			gbVO.setGb_time(st.format(date)); // 시간을 문자열로 변환
			
			req.setAttribute("GB", gbVO);
			
			RequestForwardController
			.forword(req, resp, "write");
		} else if(subPath.equals("/delete")) {
			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);
			
			System.out.println("SEQ: " + gb_seq);
			gbService.delete(gb_seq);
			resp.sendRedirect("/guest/");
			
			
		} else if(subPath.equals("/update")) {
			
			// seq값으로 데이터를 1개 찾아서
			// vo에 담고
			// writer.jsp 에 넘겨서 보여주기
			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);
			
			GuestBookVO gbVO = gbService.findById(gb_seq);
			req.setAttribute("GB", gbVO);

			RequestForwardController
			.forword(req, resp, "write");
			
		}
		
	} // doGet() end

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글설정
		req.setCharacterEncoding("UTF-8");
		
		String subPath = req.getPathInfo();
		
		
//		String gb_date = req.getParameter("gb_date");
//		String gb_time = req.getParameter("gb_time");
//		String gb_writer = req.getParameter("gb_writer");
//		String gb_email = req.getParameter("gb_email");
//		String gb_password = req.getParameter("gb_password");
//		String gb_content = req.getParameter("gb_content");
		
		// 오류를 줄이려면 아래방법으로 하는 방법이 있다!
		String gb_date = req.getParameter(DbInfo.gb_date);
		String gb_time = req.getParameter(DbInfo.gb_time);
		String gb_writer = req.getParameter(DbInfo.gb_writer);
		String gb_email = req.getParameter(DbInfo.gb_email);
		String gb_password = req.getParameter(DbInfo.gb_password);
		String gb_content = req.getParameter(DbInfo.gb_content);			
		
		GuestBookVO gbVO = new GuestBookVO();
		gbVO.setGb_date(gb_date);
		gbVO.setGb_time(gb_time);
		gbVO.setGb_writer(gb_writer);
		gbVO.setGb_email(gb_email);
		gbVO.setGb_password(gb_password);
		gbVO.setGb_content(gb_content);
		
		// 제대로 담겼는지 확인
		System.out.println(gbVO.toString());
		
		
		if(subPath.equals("/insert")) {
			
			

			gbService.insert(gbVO);
			resp.sendRedirect("/guest/");
			
		} else if(subPath.equals("/update")) {
	         
	         String strSeq = req.getParameter("gb_seq");
	         Long gb_seq = Long.valueOf(strSeq);
	         
	         gbVO.setGb_seq(gb_seq);
	         gbService.update(gbVO);
	         
	         resp.sendRedirect("/guest/");
	         
	      }
	}
	
	
	
	
}
