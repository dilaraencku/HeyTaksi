package com.ismek.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<User> findAllUser(){
		return new UserDAO().findAll();
	}

}
