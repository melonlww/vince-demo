package com.xima.design.pattern.结构型.享元模式_Flyweight.s3实例_数据库连接池;

import java.sql.Connection;

public class Test {

    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();
        Connection conn1 = connectionPool.getConnection();
        System.out.println(conn1);

        connectionPool.release(conn1);
    }
}
