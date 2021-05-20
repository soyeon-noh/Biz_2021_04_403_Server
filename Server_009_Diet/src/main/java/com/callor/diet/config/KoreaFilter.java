package com.callor.diet.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*
 * Web Browser ---- url req ----> 
 * 		tomcat ---- context ---- Filter.doFilter() 호출 ---->
 * 							---- Controller.doGet() or
 * 								 Controller.doPost() 호출
 * 필터먼저호출하고 그다음 컨트롤러
 * 
 * 
 * Controller에서 실제 업무와 연계되면서
 * 모든(많은) Controller에서 공통으로 설정해야 하는 것들이나 
 * 공통으로 처리해야 하는 것들을
 * 
 * 미리 Filter에서 처리를 하고
 * 처리된 결과를 Controller에게 전달하는 Tomcat WAS의 처리 절차
 * 
 * Filter에서 처리된 설정은
 * 모든 Controller에 일일이 설정하는 것과
 * 같은 효과를 발휘한다
 * 
 * login과 같은 처리는 
 * 사용자의 요청을 받으면 각각의 Controller가
 * 항상 login이 되어 있는지 검사하고 그에 따른 처리를 수행해야 하는데
 * 
 * 그러한 절차를 미리 Filter에서 처리하고
 * login 여부에 따라 Controller로 전달할지 안할지를 
 * 판단하여 미리 한번에 처리할 수 있다.
 */

// urlPatterns = "/food/*" 로 설정하면
// localhost:8080/diet/food 로 요청하는 부분만 처리
@WebFilter(urlPatterns = "/*") // 모든요청에 // "/food/*"이렇게하면 푸드요청만
public class KoreaFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, 
						ServletResponse resp,
						FilterChain chain)
			throws IOException, ServletException {
		// TODO 한글 Encoding 설정
		/*
		 * 프로젝트의 모든 Controller로 요청되는 
		 * 데이터들의 문자 Encoding을 설정하고
		 * 
		 * Controller에서 Web 으로 응답하는 
		 * 데이터들의 ContentType을 설정하기
		 */
		req.setCharacterEncoding("UTF-8");
		// resp.setContentType("text/html;charset=UTF-8"); // 이거때문에 css적용이안되어서 안넘어간다고??
		chain.doFilter(req, resp); // 이거 안쓰면 컨트롤러로 안넘어갈때있으니 꼭 써주기
		
		
	}

}
