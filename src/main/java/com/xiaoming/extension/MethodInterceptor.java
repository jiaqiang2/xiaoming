package com.xiaoming.extension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MethodInterceptor extends HandlerInterceptorAdapter {
		
	
		@Override
		public boolean preHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("你好，这是拦截器。。。");
			if (!(handler instanceof HandlerMethod)) {
	            return true;
	        }
			return super.preHandle(request, response, handler);
		}
}
