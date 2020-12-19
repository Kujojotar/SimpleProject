package com.james.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    static{
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
    
    private static Connection conn;
    
    public static Connection getConnection() throws SQLException {
    	String url="jdbc:mysql://localhost:3307/studentinfo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    	String user="root";
    	String password="nie200188888888";
    	if(conn==null) {
    		conn=DriverManager.getConnection(url,user,password);
    	}
    	return conn;
    }
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
