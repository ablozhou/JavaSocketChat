/** 
* @title MyIo.java
* @author Andy Zhou/周海汉  
* @date：2016年2月26日 下午10:37:59 
* Copyright 2016 zhh. All right reserved.
*  
*/
package com.abloz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
/**
 * MyIo
 * 
 */
public class MyIo {
    static String filename = "/Users/zhh/test.txt";

    public void fileReader(String filename) {
        try {
            StringBuffer sb = new StringBuffer();
            char[] cbuf = new char[1024];
            Reader r = new FileReader(filename);
            int off = 0;
            while (r.read(cbuf, off, 1024) > 0) {
                sb.append(cbuf);
            }

            System.out.println(sb);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void inputStreamReader(String filename) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf8"));
            String s;
            try {
                while ((s = br.readLine()) != null) {
                    System.out.println(s);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ;
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void clientSocketIO(String host,int port) {
       MyClient c = new MyClient(host,port);
       c.start();
    }

    public static void serverSocketIO(int port) {
       MyServer s = MyServer.getInstance(port) ;
       s.start();
    }

    public static void main(String[] args) {
        int port = 3456;
        ConnMgr c = new ConnMgr();
        c.add();
        String dir = System.getProperty("java.ext.dirs");
        System.out.println(dir);
        //System.loadLibrary("mylib");
        String classpath = new MyIo().getClass().getClassLoader().getResource("").toString();
        System.out.println(classpath);
        inputStreamReader(filename);
        System.out.println("Simple Java chat by Andy zhou.\nrun:\n\tjava -jar me.jar [s|c]\n\t default run as server");
        if (args.length == 0 || args[0].equals("s") ) {

            serverSocketIO(port);
        } else if (args[0].equals("c")) {
            clientSocketIO("localhost",port);
        }
    }

}
