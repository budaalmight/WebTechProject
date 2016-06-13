package services;

import beans.CreatePresentationDay;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.PresentationDayDAO;
import dao.SessionProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/PresentationDay")
public class PresentationDayService
{
    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String json)
    {
        Gson gson = new GsonBuilder().create();
        CreatePresentationDay presentationDay = gson.fromJson(json, CreatePresentationDay.class);
        if (SessionProvider.checkSid(presentationDay.getSid()))
        {
            PresentationDayDAO dayDAO = new PresentationDayDAO();
            if (dayDAO.create(presentationDay))
                return Response.ok("done").build();
            else
                Response.serverError().build();
        }
        else
            return Response.serverError().build();
        return Response.serverError().build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll(String sid)
    {
        if (SessionProvider.checkSid(sid))
        {
            PresentationDayDAO dayDAO = new PresentationDayDAO();
            return Response.ok(dayDAO.getAll()).build();
        }
        else
            return Response.serverError().build();
    }
}
