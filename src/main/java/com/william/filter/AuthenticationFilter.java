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
import com.william.util.JedisUtil;



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
		 HttpSession session = req.getSession();
		 //This part need to be further changed
         String id = session.getId();
         String userid = (String) session.getAttribute("userid");
         System.out.println(req.getContextPath()+"/unauthenticate");
         if(req.getRequestURI().startsWith(req.getContextPath()+"/authenticate")){
        	 if(session == null || id == null || "".equals(id)){
 	            this.context.log("Unauthorized access request");
 	            LoginResult  result = new LoginResult();
 	            result.setStatus("FAILURE");
 	            System.out.println("Unauthorized access request");
 	            response.getWriter().write(new ObjectMapper().writeValueAsString(result));	
 	        }else if((""+id).equals(JedisUtil.get(userid))){
 	            // pass the request along the filter chain
 	            chain.doFilter(request, response);
 	           System.out.println("authorized access request");
 	        } else{
 	        	this.context.log("Unauthorized access request");
 	            LoginResult  result = new LoginResult();
 	            result.setStatus("FAILURE");
 	            System.out.println("Unauthorized access request");
 	        }
         } else{
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