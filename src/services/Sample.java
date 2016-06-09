package services;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/Sample")
public class Sample
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get(){
        Gson gson = new Gson();
        Map<String,String> response = new HashMap<>();
        response.put("value","madafaka");
        return gson.toJson(response);
    }
}
