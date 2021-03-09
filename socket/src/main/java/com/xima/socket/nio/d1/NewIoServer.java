package com.xima.socket.nio.d1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIoServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    socketChannel.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array()));

                    //写出数据
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                } else {
                    Thread.sleep(1000);
                    System.out.println("连接未就绪");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
