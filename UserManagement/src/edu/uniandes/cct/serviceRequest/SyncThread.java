package edu.uniandes.cct.serviceRequest;

import java.util.Date;
import java.util.concurrent.Callable;

import edu.uniandes.cct.serviceRequest.VO.SupportRequestVO;


public class SyncThread 
	implements Callable<SupportRequestVO> {
	
    private volatile String text;
    
    public SyncThread(String text) {
        this.text = text;
    }

    public SupportRequestVO call() {
    	SupportRequestVO sr1 = new SupportRequestVO(new Date(), text);
    	return sr1;
    }
}