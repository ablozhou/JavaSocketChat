/** 
* @title Worker.java
* @author Andy Zhou/周海汉  
* @date：2016年2月27日 上午11:44:15 
* Copyright 2016 zhh. All right reserved.
*  
*/ 
package com.abloz;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Callable;

/**
 * Worker
 * 
 */
public class MyRecvWorker implements Callable<String> {

    private Socket socket;
    public MyRecvWorker(Socket socket) {
        this.socket = socket;
    }
    @Override
    public String call() throws Exception {
        
        BufferedReader socketInput = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), "UTF-8"));
        
        String line = socketInput.readLine();

        while (!line.equals("bye") && !socket.isClosed()) {
            System.out.println("other:" + line);
          
            line = socketInput.readLine();

        }
        socketInput.close();
    
        socket.close();
        return "ok";
    }

}
