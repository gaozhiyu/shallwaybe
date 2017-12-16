package com.william.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.william.util.JedisUtil;
import com.william.vo.CommonVO;

public class AuthenticationFilter implements Filter {

	private ServletContext context;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		// HttpSession session = req.getSession();
		// This part need to be further changed

		String id = null;
		String userid = null;
		Cookie[] cookies = req.getCookies();
		//String test = req.getHeader("Set-Cookie");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ("sesionCookie".equals(cookies[i].getName()))
					id = cookies[i].getValue();
				if ("userCookie".equals(cookies[i].getName()))
					userid = cookies[i].getValue();
			}
		}

		System.out.println(req.getContextPath() + "/unauthenticate");
		if (!req.getRequestURI().startsWith(req.getContextPath() + "/unauthenticate")) {
			if (id == null || "".equals(id)) {
				this.context.log("Unauthorized access request");
				CommonVO result = new CommonVO();
				result.setStatus("FAILURE");
				System.out.println("Unauthorized access request");
				response.getWriter().write(new ObjectMapper().writeValueAsString(result));
			} else if (("" + id).equals("" + JedisUtil.getAppValue(userid))) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
				System.out.println("authorized access request");
			} else {
				this.context.log("Unauthorized access request");
				CommonVO result = new CommonVO();
				result.setStatus("FAILURE");
				response.getWriter().write(new ObjectMapper().writeValueAsString(result));
				System.out.println("Unauthorized access request");
			}
		} else {
			chain.doFilter(request, response);
			System.out.println("No access request required");
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

}