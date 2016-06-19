package com.william.util;

import java.util.concurrent.ExecutorService;

import com.william.filter.LogFile;


public class ChatMessageQueue {
	private static ChatMessageQueue instance;
	private ExecutorService jobQueue;
	private MessageListener listener;
    private long time;
	public MessageListener getListener() {
		return listener;
	}

	public void setListener(MessageListener listener) {
		this.listener = listener;
	}

	private ChatMessageQueue() {
		jobQueue = java.util.concurrent.Executors.newFixedThreadPool(1);
	}

	public void postMessage(final LogFile message) {
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

	public static ChatMessageQueue getInstance() {
		if (instance == null) {
			instance = new ChatMessageQueue();
		}
		return instance;
	}

	public static interface MessageListener {
		void onMessage(LogFile msg) throws Exception;
	}

	
	
}
