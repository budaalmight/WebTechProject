package services;

import beans.CreateComment;
import beans.GetAllComments;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.CommentDAO;
import dao.SessionProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/comments")
public class CommentService
{
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(String json)
    {
        Gson gson = new GsonBuilder().create();
        CreateComment comment = gson.fromJson(json, CreateComment.class);
        if(SessionProvider.checkSid(comment.getSid())){
            CommentDAO dao = new CommentDAO();
            return Response.ok(dao.createComment(comment)).build();
        }
        else
        {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/getAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(String json){
        Gson gson = new GsonBuilder().create();
        GetAllComments request = gson.fromJson(json, GetAllComments.class);
        if(SessionProvider.checkSid(request.getSid())){
            CommentDAO dao = new CommentDAO();
            dao.getAllComments(request);
        }else
        {
            return Response.serverError().build();
        }
    }
}
