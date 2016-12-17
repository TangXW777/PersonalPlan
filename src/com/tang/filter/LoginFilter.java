package com.tang.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tang.domain.User;

/**
 * 未登录过滤器
 * @author TangXW
 *
 */
public class LoginFilter implements Filter{
	private static final List<String> exURL = new ArrayList<String>();
			
	public void init(FilterConfig filterConfig) throws ServletException {
		/**
		 * 初始化一些不需要过滤的请求
		 */
		exURL.add("/PersonalPlan/");
		exURL.add("/PersonalPlan/index.jsp");
		exURL.add("/PersonalPlan/user/login.jsp");
		exURL.add("/PersonalPlan/user/login");
		exURL.add("/PersonalPlan/nologin/nologin.jsp");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpServletResponse hResponse = (HttpServletResponse)response;
		// 如果不包含上面的请求
		if(!exURL.contains(hRequest.getRequestURI())){
			User user = (User) hRequest.getSession().getAttribute("user");
			// 如果没有登录
			if(user == null){
				PrintWriter out = response.getWriter();
				hResponse.setHeader("refresh", "0;URL=/PersonalPlan/nologin/nologin.jsp");
			}
			
		}
		
		chain.doFilter(request, response);
	}

}
