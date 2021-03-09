package com.xima.socket.nio.d2_selector多路复用机制;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NewIoServer {
    static Selector selector;

    public static void main(String[] args) {
        try {
            selector = Selector.open();
            //selector必须是非阻塞
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            /**
             * 把连接事件注册到多路复用器上
             */
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();  //阻塞机制

                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterable = selectionKeySet.iterator();
                while(iterable.hasNext()){
                    SelectionKey key = iterable.next();
                    iterable.remove();

                    if(key.isAcceptable()){//连接事件
                        handleAccept(key);
                    }else if(key.isReadable()){//读的就绪事件
                        handleRead(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void handleAccept(SelectionKey selectionKey){
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
        try {
            SocketChannel socketChannel = serverSocketChannel.accept(); //一定会有个连接
            socketChannel.configureBlocking(false);
            socketChannel.write(ByteBuffer.wrap("Hello Client，I'm NIO Server".getBytes()));
            socketChannel.register(selector, SelectionKey.OP_READ); //注册读事件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRead(SelectionKey selectionKey){
        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        try {
            socketChannel.read(byteBuffer);  //一定会有值
            System.out.println("server receive msg:" + new String(byteBuffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
