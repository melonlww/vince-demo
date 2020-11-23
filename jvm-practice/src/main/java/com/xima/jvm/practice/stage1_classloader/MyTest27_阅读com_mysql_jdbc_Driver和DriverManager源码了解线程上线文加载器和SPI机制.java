package com.xima.jvm.practice.stage1_classloader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 阅读Driver接口、DriverManager和 DriverManager#getConnection源码，加深理解线程上线文加载器和SPI机制的理解
 */
public class MyTest27_阅读com_mysql_jdbc_Driver和DriverManager源码了解线程上线文加载器和SPI机制 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         * 早起需要通过Class.forName去加载mysql驱动，
         * 后期Driver驱动已经通过SPI实现，不通过Class.forName也可以
         */
        //        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb","username","password");
        conn.close();
    }
}
