package com.example.demo.util;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	public List<String> loginEssential = Arrays.asList("/devCon/**", "/itemCon/**", "/stockCon/**"/* , "/report/**" */);

	public List<String> loginInessential = Arrays.asList("/mwCon/**", "/loginChk", "login");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginUser") == null) {
			System.out.println("미인증 사용자 요청");

			response.sendRedirect("/loginResult");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
