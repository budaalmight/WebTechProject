package dao;

import beans.CreatePresentation;
import beans.GetPresentations;
import beans.Presentation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PresentationDAO
{
    public List<Presentation> getAll(GetPresentations request)
    {

        List<Map<String, String>> result = DatabaseConnector
                .execute("SELECT * FROM PRESENTATION WHERE PRESENTATIONDAY='" + request.getPresentationDay() + "'");
        return result.stream()
                .map(line -> new Presentation(line.get("STUDENT"), line.get("PRESENTATIONDAY"), line.get("STARTTIME"),
                        line.get("COMMENTS"))).collect(Collectors.toList());

    }

    public void create(CreatePresentation request)
    {
        DatabaseConnector.execute(
                "INSERT INTO PRESENTATION (FN,PRESENTATIONDAY,STARTTIME) VALUES ('" + request.getFn() + "','" + request
                        .getPresentationDay() + "','" + request.getStartTime() + "')");
    }
}
