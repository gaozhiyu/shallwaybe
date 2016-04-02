package com.william.util;

import java.util.concurrent.ExecutorService;

import com.william.to.ShakeInDTO;


public class MessageQueue {
	private static MessageQueue instance;
	private ExecutorService jobQueue;
	private MessageListener listener;
    private long time;
	public MessageListener getListener() {
		return listener;
	}

	public void setListener(MessageListener listener) {
		this.listener = listener;
	}

	private MessageQueue() {
		jobQueue = java.util.concurrent.Executors.newFixedThreadPool(1);
	}

	public void postMessage(final ShakeInDTO message) {
		if (listener != null && jobQueue != null && !jobQueue.isShutdown()) {
			jobQueue.execute(new Runnable() {
				public void run() {
					try {
						listener.onMessage(message);
					} catch (Exception e) {
						// ...
						e.printStackTrace();
					}
				}
			});
		}
	}

	public static MessageQueue getInstance() {
		if (instance == null) {
			instance = new MessageQueue();
		}
		return instance;
	}

	public static interface MessageListener {
		void onMessage(ShakeInDTO msg) throws Exception;
	}

	
	
}
