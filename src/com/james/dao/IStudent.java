package com.james.dao;

import com.james.beans.Student;

public interface IStudent {

	Student selectStudentLogin(String num,String password);
	
	
}
