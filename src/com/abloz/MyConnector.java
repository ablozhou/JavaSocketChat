/** 
* @title Connector.java
* @author Andy Zhou/周海汉  
* @date：2016年2月27日 下午12:53:02 
* Copyright 2016 zhh. All right reserved.
*  
*/ 
package com.abloz;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Connector
 * 
 */
public class MyConnector {
    Socket socket;
    private MyRecvWorker recv;
    private MySendWorker send;
    public MyConnector(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        recv = new MyRecvWorker(socket);
        send = new MySendWorker(socket);
        es.submit(recv);
        es.submit(send);
        
    }
    
  
}
