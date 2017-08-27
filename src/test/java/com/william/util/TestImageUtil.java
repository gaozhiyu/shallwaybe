package com.william.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class TestImageUtil {
	
	public String userid = "1";

	@Test
	public void imageResize(){
		String filePath = FileUtil.getProperties().getProperty("profilePhotoDir");
		System.out.println(filePath);
		
		BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(new File(filePath+userid+".tmp.jpg"));
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImageJpg = ImageUtil.resizeImage(originalImage, type);
			ImageIO.write(resizeImageJpg, "jpg", new File(filePath+userid+".jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
