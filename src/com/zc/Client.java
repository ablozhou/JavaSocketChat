/** 
* @title Client.java
* @author Andy Zhou/周海汉  
* @date：2016年2月27日 下午12:52:23 
* Copyright 2016 知藏. All right reserved.
*  
*/ 
package com.zc;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client
 * 
 */
public class Client {
    private Socket socket;
    int port;
    String host;
    public Client(String host,int port) {
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
        Connector conn = new Connector(socket);
        conn.run();
    }
    
}
