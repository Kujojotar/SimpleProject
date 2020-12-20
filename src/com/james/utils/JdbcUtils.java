package com.james.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	
	//静态代码语句块，随着类的加载而加载，而且只加载一次
    static{
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
    
    private static Connection conn;
    
    //处理异常应该由dao完成，所以此处不需处理异常，直接throw出去
    public static Connection getConnection() throws SQLException {
    	String url="jdbc:mysql://localhost:3307/studentinfo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    	String user="root";
    	String password="nie200188888888";
    	
    	//当连接为开启或者连接中断时，重新建立连接
    	if(conn==null||conn.isClosed()) {
    		conn=DriverManager.getConnection(url,user,password);
    	}
    	return conn;
    }
    
    //关闭资源
    public static void close(Connection conn,Statement stmt,ResultSet rs) throws SQLException{
    	if(conn!=null&&!conn.isClosed()) {
    		conn.close();
    	}
    	if(stmt!=null&&!stmt.isClosed()) {
    		stmt.close();
    	}
    	if(rs!=null&&!rs.isClosed()) {
    		rs.close();
    	}
    }
}
