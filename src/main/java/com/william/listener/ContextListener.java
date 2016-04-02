package com.william.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.william.to.ShakeInDTO;
import com.william.util.MessageQueue;



public class ContextListener implements ServletContextListener {


	@SuppressWarnings("deprecation")
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Current Thread initialized");
		

		MessageQueue.getInstance().setListener(
				new MessageQueue.MessageListener() {
					
					//Detail logic message process
					public void onMessage(ShakeInDTO msg) throws Exception {
						//cgc.processGameLogic(msg);
						System.out.println("PrintedByWilliam"+msg.toString());
						
					}
				});
	}

}