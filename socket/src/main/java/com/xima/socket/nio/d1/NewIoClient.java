package com.xima.socket.nio.d1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIoClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 8080));

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("Hello, i'm SocketChannel Client".getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);

            //读取数据
            byteBuffer.clear();

            int i = socketChannel.read(byteBuffer); //阻塞
            if (i > 0) {
                System.out.println("收到了服务端的数据：" + new String(byteBuffer.array()));
            } else {
                System.out.println("没有收到数据");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
