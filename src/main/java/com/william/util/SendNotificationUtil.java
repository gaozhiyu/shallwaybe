package com.william.util;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class SendNotificationUtil {
	
		/**
		 * gcmRegId is the id which android app will give to server (one time)
		 **/
		public boolean pushNotificationToGCM(String gcmRegId, String message) {
			final String GCM_API_KEY = FileUtil.getProperties().getProperty("apiKey","AAAAzTIanJk:APA91bHraawMANpeTvilMY7snaFfbDLeAOv4znIeFTd16gue23geBs_qyRiImJOiRR0lcQS1WLQw20LgmDxZuGRgcxTG2D7ytazOxRRJjcMtyMGMHg3aSl28CSodYyefA_XNZ3ZxzNm2");
			final int retries = 3;
			Result result =null;
			Sender sender = new Sender(GCM_API_KEY);
			Message msg = new Message.Builder().addData("message", message).build();
			try {
				if (gcmRegId != null) {
					 result = sender.send(msg, gcmRegId, retries);
					/**
					 * if you want to send to multiple then use below method
					 * send(Message message, List<String> regIds, int retries)
					 **/
					if (StringUtils.isEmpty(result.getErrorCodeName())) {
						System.out.println("GCM Notification is sent successfully" + result.toString());
						return true;
					}
					System.out.println("Error occurred while sending push notification :" + result.getErrorCodeName());
				}
			} catch (InvalidRequestException e) {
				e.printStackTrace();
				System.out.println("Invalid Request");
			} catch (IOException e) {
				System.out.println("IO Exception");
			}
			return false;
		}
	
}
