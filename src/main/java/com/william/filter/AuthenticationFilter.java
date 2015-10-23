package com.william.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.william.to.LoginResult;



public class AuthenticationFilter implements Filter {

	private ServletContext context;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletRequest req = (HttpServletRequest) request;
		 HttpSession session = req.getSession(false);
		 //This part need to be further changed
         //String id = session.getId();
         chain.doFilter(request, response);
         /*
	        if(session == null || id == null || "".equals(id)){
	            this.context.log("Unauthorized access request");
	            LoginResult  result = new LoginResult();
	            result.setStatus("FAILURE");
	            response.getWriter().write(new ObjectMapper().writeValueAsString(result));	
	        }else{
	            // pass the request along the filter chain
	            chain.doFilter(request, response);
	        }
	        */
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

}