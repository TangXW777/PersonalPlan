package com.tang.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;

/**
 * 国际化过滤器
 * 设置请求参数request_locale
 * @author TangXW
 *
 */
public class InternationalFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest)request;
		String request_locale = hRequest.getParameter("request_locale");
		// 如果有这个请求参数时，放入session中
		if(request_locale != null){
			hRequest.getSession().setAttribute("request_locale", request_locale);
		}else{
			// 没有这个请求参数，则从session中获取这个属性，并将其设置成请求参数
			String session_locale = (String) hRequest.getSession().getAttribute("request_locale");
			if(session_locale != null){
				// 构造一个映射关系与指定 Map 相同的新 HashMap。
				Map<String,String[]> m = new HashMap<String,String[]>(request.getParameterMap());  
				m.put("request_locale", new String[]{session_locale});  
			}
		}

		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}





