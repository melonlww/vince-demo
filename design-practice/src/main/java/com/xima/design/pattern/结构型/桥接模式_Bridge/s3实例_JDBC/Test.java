package com.xima.design.pattern.结构型.桥接模式_Bridge.s3实例_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * 加载Driver类的时候将驱动注册到registeredDrivers中
 *
 * DriverManager.getConnection时，会从registeredDrivers取出驱动
 */
public class Test {
    public static void main(String[] args) {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接Connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "liww820");
            //得到执行sql语句对象的Statement
            Statement stmt = conn.createStatement();
            //执行sql语句，并返回结果
            ResultSet rs = stmt.executeQuery("select * from student");
            //处理数据库的返回结果(使用ResultSet类)
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("age"));
            }
            //关闭资源
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
