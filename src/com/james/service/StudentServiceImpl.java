package com.james.service;

import com.james.beans.Student;
import com.james.dao.IStudent;
import com.james.dao.StudentDaoImpl;

public class StudentServiceImpl implements IstudentService {
    private IStudent dao;
    
    public StudentServiceImpl() {
    	dao=new StudentDaoImpl();
    }
	@Override
	public Student checkUser(String num, String password) {
		// TODO Auto-generated method stub
		return dao.selectStudentLogin(num,password);
	}

}
