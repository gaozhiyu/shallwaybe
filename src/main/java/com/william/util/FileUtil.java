package com.william.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

public class FileUtil {
	
	public static Properties property;
	public static byte[] getFileData(String userid) throws IOException{
		//InputStream is;
		//FileInputStream is = new FileInputStream("d:/shallwayprofilephoto/"+userid+".jpg");
		String path = getProperties().getProperty("profilePhotoDir");
		FileInputStream is = new FileInputStream(path+userid+".jpg");
		byte[] bytes = IOUtils.toByteArray(is);
		return bytes;
	}
	
	public static Properties getProperties(){
		if(property==null){
			try{
				property = new Properties();
				InputStream is = FileUtil.class.getResourceAsStream("appconfig.property");
				property.load(is);
			} catch (Exception e ){
				
			}
			
		}
		return property;
	}
}
