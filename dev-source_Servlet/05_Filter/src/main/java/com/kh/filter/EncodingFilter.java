package com.kh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 필터란?
 * 서블릿이 호출되기 전과 그리고 응답 후에 Stream을 특수처리(필터링) 하기 위해 사용되는 클래스
 */

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*") // 모든 페이지 필터링
public class EncodingFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Filter가 생성되고 최초 한번만 실행되는 메소드
		System.out.println(filterConfig.getFilterName() + "필터가 생성됨!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 실제 필터링을 하는 메소드
		System.out.println("서블릿 호출 이전에 필터가 호출된다!");
		
		// 모든 요청과 응답의 character set UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 서블릿이 호출되기 전에 처리되는 영역!
		chain.doFilter(request, response);
		// 서블릿이 호출되고 나서 후 처리 영역!	
		
		System.out.println("서블릿 이후에 필터가 다시 호출되는 영역!");
	}
	
	@Override
	public void destroy() {
		// 필터가 소멸될때 생성되는 메소드
		System.out.println("필터가 소멸되는 곳!");
	}
}
