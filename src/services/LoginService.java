package services;

import beans.LoginUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.UserDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class LoginService
{
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(String element)
    {
        Gson gson = new GsonBuilder().create();
        LoginUser user = gson.fromJson(element, LoginUser.class);
        UserDAO dao = new UserDAO();
        return "{ \"sid\" : \"" + dao.checkUserCredentials(user) + "\"}";
    }
}
