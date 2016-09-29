package edu.uniandes.cct.serviceRequest;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueManager {
	
    private static LinkedBlockingQueue<String> taskQueue = null;

    public QueueManager() {
        taskQueue = new LinkedBlockingQueue<String>();
    }

    public void addRequest(String request){
        taskQueue.add(request);
    }
    
    public String getRequest() throws InterruptedException{
        return taskQueue.take();
    }

    public static LinkedBlockingQueue<String> getTaskQueue() {
        return taskQueue;
    }

    public static void setTaskQueue(LinkedBlockingQueue<String> taskQueue) {
    	QueueManager.taskQueue = taskQueue;
    }
    
    public boolean isEmpty(){
    	return taskQueue.isEmpty();
    }

}
