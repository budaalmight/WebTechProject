package dao;

import beans.CreatePresentationDay;
import beans.PresentationDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PresentationDayDAO
{
    public List<PresentationDay> getAll()
    {
        try
        {
            ResultSet resultSet = DatabaseConnector.getStatement().executeQuery("SELECT * FROM PRESENTATIONDAY");
            List<PresentationDay> result = new ArrayList<>();
            result.add(new PresentationDay(resultSet.getString("DATE"), resultSet.getString("DURATION"),
                    resultSet.getString("STARTTIME"), resultSet.getString("ENDTIME")));
            while (resultSet.next())
            {
                result.add(new PresentationDay(resultSet.getString("DATE"), resultSet.getString("DURATION"),
                        resultSet.getString("STARTTIME"), resultSet.getString("ENDTIME")));
            }
            return result;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean create(CreatePresentationDay request)
    {
        try
        {
            return DatabaseConnector.getStatement().execute(
                    "INSERT INTO PRESENTATIONDAY VALUES(" + request.getDate() + "," + request.getDuration() + "," + request
                            .getStartTime() + "," + request.getEndTime() + ")");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
