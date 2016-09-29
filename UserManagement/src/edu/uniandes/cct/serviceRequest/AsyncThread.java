package edu.uniandes.cct.serviceRequest;

public class AsyncThread extends Thread {

    private QueueManager taskQueue;

    public QueueManager getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(QueueManager taskQueue) {
        this.taskQueue = taskQueue;
    }

    public AsyncThread() {
    	
    }

    public void run() {

        String task = null;
        while (true) {

            try {
                //System.out.println("Async Thread running...");
                if(taskQueue != null)
                {
                	task = taskQueue.getRequest();
                	if(task != null)
                		execute(task);
                }
                else
                {
                	Thread.sleep(4000);
                }
            } catch (Exception e) {

                System.out.println("Exception on thread, please contact system admin!");
            }
        }
    }
    
    public void execute(String task){
    	
       //System.out.println("Execute Asyn...");
       //System.out.println("Asynchronous processing of ticket :" + task);
       try {
    	   //Simulando el procesamiento de SR.
		   Thread.sleep(500);
       } catch (InterruptedException e) {
    	   
       }
       
    }
}
