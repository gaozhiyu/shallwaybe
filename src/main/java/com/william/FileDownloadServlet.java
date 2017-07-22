package com.william;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.william.util.FileUtil;

public class FileDownloadServlet extends HttpServlet {
	
	private final Logger logger =  Logger.getLogger(this.getClass());
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			OutputStream out = response.getOutputStream();
			String userid= (String)request.getParameter("id");
			String path = FileUtil.getProperties().getProperty("profilePhotoDir","/media/shallwayProfilePhoto/");
			FileInputStream in = new FileInputStream(path+userid+".jpg");
			//FileInputStream in = new FileInputStream("d:/shallwayprofilephoto/"+userid+".jpg");
			byte[] buffer = new byte[4096];
			int length;
			while ((length = in.read(buffer)) > 0){
			    out.write(buffer, 0, length);
			}
			in.close();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
 



	 
}
