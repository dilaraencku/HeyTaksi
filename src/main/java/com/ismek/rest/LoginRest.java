package com.ismek.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ismek.dao.UserDAO;
import com.ismek.dto.BaseReturn;
import com.ismek.dto.UserLoginDTO;
import com.ismek.entity.User;

@Path("/loginRest")
public class LoginRest {
	
	UserDAO userDAO = new UserDAO();
	
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

    @PUT
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void updateUser(@PathParam("userId") long id, User user) {
        try {
            user.setId(id);
            userDAO.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public BaseReturn<User> login(UserLoginDTO userDto) {
    	BaseReturn<User> response = new BaseReturn<>();
        try {
            User user = userDAO.login(userDto.getUsername(), userDto.getPassword());
            if (user == null) {
				response.setResult(false);
				response.setMessage("Kullanıcı adı veya şifre yanlış!");
			}else{
				response.setResult(true);
				response.setData(user);
			}
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(false);
			response.setMessage(e.getMessage());
        }
        return response;
    }

}
