package services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class Session
{
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@QueryParam("username") String username,@QueryParam("password") String password){
        return null;
    }
}
