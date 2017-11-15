package com.ismek.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.ismek.dao.UserDAO;
import com.ismek.entity.User;

@Path("/TestRest")
public class TestRest {

    UserDAO userDAO = new UserDAO();

    @GET
    @Path("/test")
    public String test() {
        return "Hello Rest";
    }

    @GET
    @Path("/findAllUser")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<User> findAllUser() {
        return new UserDAO().findAll();
    }

    @GET
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public User findOneUser(@PathParam("userId") long id) {
        return new UserDAO().findUserbyId(id);
    }

    @DELETE
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteUser(@PathParam("userId") long id) {

        try {
            userDAO.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
