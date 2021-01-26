package com.xima.design.pattern.结构型.享元模式_Flyweight.s3实例_数据库连接池;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {
    private Vector<Connection> pool;
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "liww820";
    private String driverClassName = "com.mysql.cj.jdbc.Driver";
    private int poolSize = 20;

    public ConnectionPool() {
        pool = new Vector<Connection>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driverClassName);
                Connection conn = DriverManager.getConnection(url, username, password);
                pool.add(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection conn = pool.get(0);
            pool.remove(conn);
            return conn;
        }
        return null;
    }

    public synchronized void release(Connection conn) {
        pool.add(conn);
    }
}
