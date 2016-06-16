package dao;

import beans.CreatePresentationDay;
import beans.PresentationDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PresentationDayDAO
{
    public List<PresentationDay> getAll()
    {
        List<Map<String, String>> result = DatabaseConnector.execute("SELECT * FROM PRESENTATIONDAY");
        return result.stream().map(line -> new PresentationDay(line.get("DATE"), line.get("DURATION"), line.get("STARTTIME"),
                line.get("ENDTIME"))).collect(Collectors.toList());
    }

    public void create(CreatePresentationDay request)
    {
        DatabaseConnector.execute(
                "INSERT INTO PRESENTATIONDAY (DATE,DURATION,STARTTIME,ENDTIME) VALUES('" + request.getDate() + "','" + request
                        .getDuration() + "','" + request.getStartTime() + "','" + request.getEndTime() + "')");
    }
}
