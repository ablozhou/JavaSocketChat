/** 
* @title Client.java
* @author Andy Zhou/周海汉  
* @date：2016年2月27日 下午12:52:23 
* Copyright 2016 zhh. All right reserved.
*  
*/ 
package com.abloz;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client
 * 
 */
public class MyClient {
    private Socket socket;
    int port;
    String host;
    public MyClient(String host,int port) {
        this.host = host;
        this.port = port;
    }
    public void start() {
        try {
            this.socket = new Socket(host,port);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        MyConnector conn = new MyConnector(socket);
        conn.run();
    }
    
}
