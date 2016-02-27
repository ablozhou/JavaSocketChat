/** 
* @title SendWorker.java
* @author Andy Zhou/周海汉  
* @date：2016年2月27日 上午11:44:15 
* Copyright 2016 知藏. All right reserved.
*  
*/ 
package com.zc;

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
public class SendWorker implements Callable<String> {

    private Socket socket;
    public SendWorker(Socket socket) {
        this.socket = socket;
    }
    @Override
    public String call() throws Exception {
        BufferedReader meInput = new BufferedReader(
                new InputStreamReader(System.in, "UTF-8"));
        
        PrintWriter socketOutput = new PrintWriter(socket.getOutputStream());
        String line = meInput.readLine();

        while (!line.equals("bye") && !socket.isClosed()) {
            socketOutput.println(line);
            socketOutput.flush();
            //System.out.println("me:" + line);
            line = meInput.readLine();

        }
        socketOutput.close();
        meInput.close();
        socket.close();
        return "ok";
    }

}
