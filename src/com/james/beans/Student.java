package com.james.beans;

import java.io.Serializable;

public class Student implements Serializable{
    /**
	 * 
	 */
	private Integer id;
	private String num;
    private String password;
    private String name;
    private Integer age;
    
    public Student() {
    	super();
    }
    
    public Student(String num,String name,int age) {
    	super();
    	this.num=num;
    	this.name=name;
    	this.age=age;
    }
    
    public String getNum() {
		return num;
	}
    
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
    
}
