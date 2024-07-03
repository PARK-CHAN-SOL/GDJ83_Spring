package com.sol.app.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FirstFilter
 */
public class FirstFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FirstFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		// Filter 객체가 소멸시 실행하는 메서드
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("First Filter IN");
		
		chain.doFilter(request, response);
		//응답 나갈 때 실행
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("First Filter OUT");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		// Filter 객체가 생성시 실행하는 메서드
	}

}
