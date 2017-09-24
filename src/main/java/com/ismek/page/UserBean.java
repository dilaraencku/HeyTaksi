package com.ismek.page;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ismek.dao.UserDAO;
import com.ismek.entity.User;
@ManagedBean(name = "userBean", eager = true)
@RequestScoped
public class UserBean {
	private String name;
	private Integer age;
	public String saveUser(){
		UserDAO userDao = new UserDAO();
		Integer userId= userDao.getId();
		User user = new User(userId, name, age);
		userDao.save(user);
		System.out.println("User successfully saved.");
		return "output";
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
}