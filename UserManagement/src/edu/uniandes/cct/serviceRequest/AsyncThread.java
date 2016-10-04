package ServiceDesk;

import ServiceDesk.VO.ClientVO;
import ServiceDesk.VO.SupportRequestVO;
import ServiceDesk.VO.SupportResponsibleVO;

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

    	SupportRequestVO task = null;
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
    
    public void execute(SupportRequestVO task){
    	
       //System.out.println("Execute Asyn...");
       System.out.println("Asynchronous processing of ticket :" + task.getTicketNumber() + "-" + task.getCreationText());
       try {
    	   //Simulando el procesamiento de SR.
    	   String creationText = task.getCreationText();
    	   String[] clientInfo = creationText.split(";");
    	   String id = clientInfo[0];
    	   String name = clientInfo[1];
    	   String description = clientInfo[2];
    	   String job = clientInfo[3];
    	   String area = clientInfo[4];
    	   ClientVO client = new ClientVO(id,name,job,area);
    	   SupportResponsibleVO responsible = new SupportResponsibleVO("Support Agent");
    	   task.setClient(client);
    	   task.setAssignedTo(responsible);
    	   task.setDescription(description);
    	   task.save();
    	   
       } catch (Exception e) {
    	   
       }
       
    }
}
