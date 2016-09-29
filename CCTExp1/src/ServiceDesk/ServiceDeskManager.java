package ServiceDesk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ServiceDesk.VO.SupportRequestVO;

public class ServiceDeskManager {

	private static AsyncProcessing asyncProcessing = null;
	private static QueueManager taskQueue = null;
	
	public ServiceDeskManager()
	{
		asyncProcessing = new AsyncProcessing();
		taskQueue = new QueueManager();
	}
	
	public String CreateRequest(String text)
	{
		final ExecutorService service;
        final Future<SupportRequestVO>  task;     
        String value = "";
        service = Executors.newFixedThreadPool(1);        
        task    = service.submit(new SyncThread(text));
        
        try {

            final SupportRequestVO sr;
            sr = task.get(); // this raises ExecutionException if thread dies
            text = sr.getCreationText();
            value = sr.getTicketNumber();
            ServiceDeskManager.taskQueue.addRequest(value + "|" + text);
        } catch(final InterruptedException ex) {
            ex.printStackTrace();
        } catch(final ExecutionException ex) {
            ex.printStackTrace();
        }
        service.shutdownNow();
        return value;
	}
	
	public void StartAsyncProcessing()
	{
        ServiceDeskManager.asyncProcessing.setTaskQueue(taskQueue);
        ServiceDeskManager.asyncProcessing.createThreadPool();
	}
}

