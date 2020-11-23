package com.xima.jvm.practice.stage2_bytecode;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 *
 */
public class MyTest3_1_异常表 {

    public void test() throws IOException,NullPointerException {

        InputStream is = new FileInputStream("test.txt");

        ServerSocket serverSocket = new ServerSocket(9999);
        serverSocket.accept();

        System.out.println("finally");

    }

    public static void main(String[] args) {
        MyTest3_1_异常表 myTest3 = new MyTest3_1_异常表();
        try {
            myTest3.test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
