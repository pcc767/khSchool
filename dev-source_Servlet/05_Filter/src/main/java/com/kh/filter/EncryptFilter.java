package com.kh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.kh.wrapper.EncryptWrapper;

//@WebFilter(filterName = "EncryptFilter", servletNames = {"loginServlet", "enrollServlet"})
@WebFilter(filterName = "EncryptFilter", urlPatterns = "/views/member/enrollResult.jsp")
public class EncryptFilter implements Filter{
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EncryptFilter 호출됨");

		EncryptWrapper wrapper = new EncryptWrapper((HttpServletRequest) request);
		
		// wrapper 활용시 request 자리에 대신 넣으면 된다.
		chain.doFilter(wrapper, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
