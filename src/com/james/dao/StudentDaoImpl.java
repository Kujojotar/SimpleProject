package com.james.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.james.beans.Student;
import com.james.utils.JdbcUtils;

public class StudentDaoImpl implements IStudent {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement ps;
    private ResultSet rs;
	
	@Override
	public Student selectStudentLogin(String num, String password) {
		Student student=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from studentinfo where num=? and password = ?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, num);
				ps.setString(2, password);
				rs=ps.executeQuery();
				if(rs.next()) {
					student=new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setAge(rs.getInt("age"));
					student.setNum(rs.getString("num"));
					student.setPassword(rs.getString("password"));
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtils.close(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

}
