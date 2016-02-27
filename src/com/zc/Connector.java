/** 
* @title Connector.java
* @author Andy Zhou/周海汉  
* @date：2016年2月27日 下午12:53:02 
* Copyright 2016 知藏. All right reserved.
*  
*/ 
package com.zc;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Connector
 * 
 */
public class Connector {
    Socket socket;
    RecvWorker recv;
    SendWorker send;
    public Connector(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        recv = new RecvWorker(socket);
        send = new SendWorker(socket);
        es.submit(recv);
        es.submit(send);
        
    }
    
  
}
