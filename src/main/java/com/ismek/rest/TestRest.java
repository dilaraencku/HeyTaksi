package com.ismek.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/TestRest")
public class TestRest {
	
	@GET
	@Path("/test")
	public String test(){
		return "Hello Rest";
	}

}
