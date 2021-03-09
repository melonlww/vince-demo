package com.xima.socket.bio.d2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketDemo {

    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //localhost:8080
            serverSocket = new ServerSocket(8080);
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("客户端端口：" + socket.getPort());

                executorService.execute(new SocketThread(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
