package com.james.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.james.utils.JdbcUtils;

public class StudentRegistDaoImpl implements IStudentRegist {
	    private Connection conn;
	    private Statement stmt;
	    private PreparedStatement ps;
	    private ResultSet rs;
	    
	    public StudentRegistDaoImpl() {
	    	super();
	    }
	    
	@Override
	public boolean registInform(String name, String num, String password, String age) {
		int a=0;
		try {
			conn=JdbcUtils.getConnection();
			String sql="insert into studentinfo (name,num,password,age) values ('"
					+name+"' , '"+num+"','"+password+"' , "+age+" );";
				ps=conn.prepareStatement(sql);
				a=ps.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtils.close(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(a==1) {
			return true;
		}
		return false;
	}
}
