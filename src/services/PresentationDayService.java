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
            dayDAO.create(presentationDay);
            return Response.ok("Done.").build();
        }
        else
            return Response.serverError().build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getAll(String sid)
    {
        Gson gson = new GsonBuilder().create();
        if (SessionProvider.checkSid(sid))
        {
            PresentationDayDAO dayDAO = new PresentationDayDAO();

            return gson.toJson(dayDAO.getAll());
        }
        else
            return gson.toJson("Not an active sid");
    }
}
