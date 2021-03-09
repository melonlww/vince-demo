package com.xima.socket.nio.d2_selector多路复用机制;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NewIoClient {

    static Selector selector;

    public static void main(String[] args) {
        try {
            selector = Selector.open();

            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 8080));
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            while (true) {
                selector.select();

                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterable = selectionKeySet.iterator();

                while (iterable.hasNext()) {
                    SelectionKey key = iterable.next();
                    iterable.remove();

                    if (key.isConnectable()) {//连接事件
                        handleConnect(key);
                    } else if (key.isReadable()) {//读的就绪事件
                        handleRead(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void handleConnect(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        try {
            if (socketChannel.isConnectionPending()) {
                //
                socketChannel.finishConnect();
            }
            socketChannel.configureBlocking(false);
            socketChannel.write(ByteBuffer.wrap("Hello Server, I'm NIO Client".getBytes()));
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void handleRead(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        try {
            socketChannel.read(byteBuffer);  //一定会有值
            System.out.println("client receive msg:" + new String(byteBuffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
