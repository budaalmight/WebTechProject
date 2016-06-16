package services;

import beans.RegisterUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.UserDAO;

@Path("/users")
public class RegisterService
{
    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(String json)
    {
        Gson gson = new GsonBuilder().create();
        RegisterUser user = gson.fromJson(json, RegisterUser.class);
        UserDAO userDAO = new UserDAO();
        Response response;
        userDAO.createUser(user);
        response = Response.ok("Done").build();
        return response;
    }
}
