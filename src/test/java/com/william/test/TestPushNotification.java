package com.william.test;

import org.junit.Test;

import com.william.util.SendNotificationUtil;

public class TestPushNotification {

	
	@Test
	public void testPushMsgToAndroid(){
		String regid="APA91bFmkaJT5TNZ5XRQfOiD8Slee6xK7-tUDJEmYS61fzi6RrrnlrOB4_gwlIl8oOFjzYp80O-aXcp6wNQLssfp_lph1THBKGf3urFYe9eXnOO2HWuswvVMq7_IVkcIie-TxiRrzItm";
		
		SendNotificationUtil test = new SendNotificationUtil();
		test.pushNotificationToGCM(regid, "test");
		
	}
}
