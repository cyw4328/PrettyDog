package com.pretty.dog.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean pass = false;
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("loginId") != null) {
			pass = true;
		}else {
			pass = false;
			response.sendRedirect("/gudi/");
		}
		
		return pass;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("loginId");
		String content = id + "님 반갑습니다. <button onclick=\"location.href='logout'\">logout</button>";
		mav.addObject("loginBox", content);
	}
	

	
	
	
}
