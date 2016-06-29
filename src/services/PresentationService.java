package services;

import beans.CreatePresentation;
import beans.GetPresentations;
import beans.Presentation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.PresentationDAO;
import dao.SessionProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/Presentation")
public class PresentationService
{
    @POST
    @Path("/getAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(String json)
    {
        Gson gson = new GsonBuilder().create();
        GetPresentations getPresentations = gson.fromJson(json, GetPresentations.class);
        if (SessionProvider.checkSid(getPresentations.getSid()))
        {
            PresentationDAO dao = new PresentationDAO();
            List<Presentation> presentations = dao.getAll(getPresentations);
            return gson.toJson(presentations);
        }
        else
            return "Invalid sid.";
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String json)
    {
        Gson gson = new GsonBuilder().create();
        CreatePresentation presentation = gson.fromJson(json, CreatePresentation.class);
        if (SessionProvider.checkSid(presentation.getSid()))
        {
            PresentationDAO dao = new PresentationDAO();
            dao.create(presentation);
            return Response.ok("Done").build();
        }
        return Response.serverError().build();
    }
}
