package com.xima.socket.bio.d2;

import java.io.*;
import java.net.Socket;

public class SocketThread implements Runnable {

    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String clientStr = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            clientStr = bufferedReader.readLine();

            System.out.println("接收到客户端信息：" + clientStr);

            //写回去
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我收到了信息\n");
            bufferedWriter.flush();

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
