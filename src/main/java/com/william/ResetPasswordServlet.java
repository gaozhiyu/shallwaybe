package com.william;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.william.util.Position;

public class ResetPasswordServlet extends HttpServlet {
	
	private final Logger logger =  Logger.getLogger(this.getClass());
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out;
		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
 


}
