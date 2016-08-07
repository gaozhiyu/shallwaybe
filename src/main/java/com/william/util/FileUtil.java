package com.william.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileUtil {
	public static byte[] getFileData(String userid) throws IOException{
		//InputStream is;
		FileInputStream is = new FileInputStream("d:/shallwayprofilephoto/"+userid+".jpg");
		byte[] bytes = IOUtils.toByteArray(is);
		return bytes;
	}
}
