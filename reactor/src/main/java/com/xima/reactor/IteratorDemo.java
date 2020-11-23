package com.xima.reactor;

import java.util.Iterator;
import java.util.List;

/**
 * Iterator通过拉模式主动获取数据
 */
public class IteratorDemo {

    public static void main(String[] args) {

        List<Integer> values = List.of(1, 2, 3, 4, 5);
        //迭代
        //数据消费
        Iterator<Integer> iterator = values.iterator();

        while (iterator.hasNext()) {  //这个过程就是向服务器请求是否还有数据
            Integer value = iterator.next();    //主动获取数据 ps.谁主动看客户端
            System.out.println(value);
        }
    }
}
