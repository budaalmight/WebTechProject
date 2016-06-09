package services;

import dao.UserDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginService
{
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(@QueryParam("username") String username,@QueryParam("password") String password){
        UserDAO dao = new UserDAO();
        return dao.checkUserCredentials(username,password);
    }
}
