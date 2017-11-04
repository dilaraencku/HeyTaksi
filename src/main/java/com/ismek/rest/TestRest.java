package com.ismek.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.ismek.dao.UserDAO;
import com.ismek.entity.User;

@Path("/TestRest")
public class TestRest {
	
	@GET
	@Path("/test")
	public String test(){
		return "Hello Rest";
	}
	
	@GET
	@Path("/findAllUser")
	public List<User> findAllUser(){
		return new UserDAO().findAll();
	}

}
