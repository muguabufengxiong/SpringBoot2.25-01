package com.example.SpringBoot25.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class MyInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object uname = request.getSession().getAttribute("uname");
		if(uname==null) {
			request.setAttribute("msg", "请先进行登录后访问");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		}
		return true;
	}
	
}
