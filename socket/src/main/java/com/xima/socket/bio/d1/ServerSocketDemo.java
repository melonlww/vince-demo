package com.xima.socket.bio.d1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //localhost:8080
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            System.out.println("客户端端口：" + socket.getPort());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientStr = bufferedReader.readLine();
            System.out.println("接收到客户端信息：" + clientStr);

            //写回去
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我收到了信息\n");
            bufferedWriter.flush();

            bufferedReader.close();
            bufferedWriter.close();
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
