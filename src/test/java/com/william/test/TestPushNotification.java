package com.william.test;

import org.junit.Test;

import com.william.util.SendNotificationUtil;

public class TestPushNotification {

	
	@Test
	public void testPushMsgToAndroid(){
		String regid="APA91bFlhLLzDUF-k5wZnqwv2YALZoPNPGPaoSwdMQHE2nU8XH1vPop5gg9ODnlrqkM-kV5SGDJ0C0FwCkAfEVmgWb7kxfqn22GhsEt2wAE-NzbXqX-Yw-97jrVqtDJc5X4-eerbuyeP";
		
		SendNotificationUtil test = new SendNotificationUtil();
		test.pushNotificationToGCM(regid, "cc8079f38f92437b866b933ac8a0660d");
		
	}
}
