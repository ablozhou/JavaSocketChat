/** 
* @title Server.java
* @author Andy Zhou/周海汉  
* @date：2016年2月27日 下午12:58:36 
* Copyright 2016 zhh. All right reserved.
*  
*/
package com.abloz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Server
 * 
 */
public class MyServer {
    public int port;
    HashMap<String, MyConnector> conns;
    static MyServer instance;

    public static MyServer getInstance(int port) {
        if (instance == null) {
            instance = new MyServer(port);
        }
        return instance;
    }

    private MyServer(int port) {
        conns = new HashMap<String, MyConnector>();
        this.port = port;
    }

    public void add(String key, MyConnector value) {
        conns.put(key, value);
    }

    public void remove(String key) {
        conns.remove(key);
    }

    public void start() {

        try {
            ServerSocket s = new ServerSocket(port);
            Socket c = s.accept();

            while (c != null) {
                MyConnector conn = new MyConnector(c);

                // 客户端连接加入容器
                add(String.valueOf(c.getPort()), conn);

                conn.run();

                c = s.accept();
            }
            s.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
