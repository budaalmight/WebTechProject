package services;

import beans.Comment;
import beans.CreateComment;
import beans.GetAllComments;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.SessionProvider;
import dao.CommentDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
            dao.createComment(comment);
            return Response.ok("Ok").build();
        }
        else
        {
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/getAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(String json){
        Gson gson = new GsonBuilder().create();
        GetAllComments request = gson.fromJson(json, GetAllComments.class);
        if(SessionProvider.checkSid(request.getSid())){
            CommentDAO dao = new CommentDAO();
            List<Comment> comments = dao.getAllComments(request);
            return Response.ok(gson.toJson(comments)).build();
        }else
        {
            return Response.serverError().build();
        }
    }
}
