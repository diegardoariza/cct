package com.lmax.outputdisruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.lmax.utils.CircularQueueManager;

public class OutputAsyncProcessing {
	private CircularQueueManager outputQueue;
	
    public CircularQueueManager getTaskQueue() {
        return outputQueue;
    }

    public void setEventQueue(CircularQueueManager outputQueue) {
        this.outputQueue = outputQueue;
    }

    public void createThreadPool() {

        ExecutorService ex = Executors.newFixedThreadPool(10);
        OutputAsyncThread t;
        for (int i = 0; i < 10; i++) {
            t = new OutputAsyncThread();
            t.setEventQueue(outputQueue);
            ex.execute(t);
        }
        ex.shutdown();
    }
}
