package com.james.service;

import com.james.dao.*;

public class StudentRegistServiceImpl implements IstudentRegistService {
    
	private IStudentRegist dao;
    
    public StudentRegistServiceImpl() {
    	dao=new StudentRegistDaoImpl();
    }
    @Override
    public boolean regist(String name, String num, String password, String age) {
		
		return dao.registInform(name,num,password,age);
	}

}
