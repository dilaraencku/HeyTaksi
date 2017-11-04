package com.ismek.page;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ismek.dao.UserDAO;
import com.ismek.entity.User;

@ManagedBean(name = "userBean", eager = true)
@RequestScoped
public class UserBean {
	private String name;
	private Date birthday;
	private String lastName;
	private String email;
	private String password;
	
	public String saveUser(){
		UserDAO userDao = new UserDAO();
		User user = new User(0, name,lastName,email,birthday,password);
		userDao.save(user);
		System.out.println("User successfully saved.");
		return "output";
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}