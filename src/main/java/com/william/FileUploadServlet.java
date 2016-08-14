package com.william;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.william.DAO.ProfileDAO;
import com.william.to.ProfileInDTO;
import com.william.util.Position;

public class FileUploadServlet extends HttpServlet {
	
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
		Date currentTime = new Date();
		try {
			byte[] body = readBody(request);

	        String textBody = new String(body, "ISO-8859-1");
	        String userid = (String)request.getParameter("id");//TODO in future
	       // String fileName = getFileName(textBody);

	        Position p = getFilePosition(request, textBody);

	        writeTo(userid+".jpg", body, p);
	        
	        ProfileDAO pDAO = ProfileDAO.getInstance();
	        ProfileInDTO profileTo = new ProfileInDTO();
	        profileTo.setUserIntID(userid);
//	        profileTo.setProfilePhoto("TRUE");
	        profileTo.setProfilePhoto(currentTime);
			pDAO.updateProfile(profileTo);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
 



	 private byte[] readBody(HttpServletRequest request) throws IOException {

	        int formDataLength = request.getContentLength();

	        DataInputStream dataStream = new DataInputStream(request.getInputStream());
	        byte body[] = new byte[formDataLength];
	        int totalBytes = 0;
	        while (totalBytes < formDataLength) {
	            int bytes = dataStream.read(body, totalBytes, formDataLength);
	            totalBytes += bytes;
	        }
	        return body;
	    }
	 
	    private Position getFilePosition(HttpServletRequest request, String textBody) throws IOException {

	        String contentType = request.getContentType();
	        String boundaryText = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());

	        int pos = textBody.indexOf("filename=\"");
	        pos = textBody.indexOf("\n", pos) + 1;
	        pos = textBody.indexOf("\n", pos) + 1;
	        pos = textBody.indexOf("\n", pos) + 1;
	        int boundaryLoc = textBody.indexOf(boundaryText, pos) - 4;
	        int begin = ((textBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
	        int end = ((textBody.substring(0, boundaryLoc)).getBytes("ISO-8859-1")).length;
	 
	        return new Position(begin, end);
	    }
	 
	    private String getFileName(String requestBody) {
	        String fileName = requestBody.substring(requestBody.indexOf("filename=\"") + 10);
	        fileName = fileName.substring(0, fileName.indexOf("\n"));
	        fileName = fileName.substring(fileName.indexOf("\n") + 1, fileName.indexOf("\""));
	 
	        return fileName;
	    }
	 
	    private void writeTo(String fileName, byte[] body, Position p) throws IOException {
	        FileOutputStream fileOutputStream = new FileOutputStream("d:/shallwayprofilephoto/" + fileName);
	        fileOutputStream.write(body, p.begin, (p.end - p.begin));
	        fileOutputStream.flush();
	        fileOutputStream.close();
	    }
}
