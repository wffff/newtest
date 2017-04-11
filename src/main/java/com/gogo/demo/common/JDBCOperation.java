package com.gogo.demo.common;

/**
 * Created by Administrator on 2017/4/7.
 */
import java.sql.*;
public class JDBCOperation {
    public static Connection getConn() {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "wangfeng";
        String password = "123";
        Connection conn = null;
        try {
            Class.forName(driver); // classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
