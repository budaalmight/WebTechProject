package dao;

import beans.CreatePresentationDay;
import beans.PresentationDay;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PresentationDayDAO
{
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm");
    public List<PresentationDay> getAll()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/webtechdb","root","buda123");
                Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM webtechdb.presentationday");
            List<PresentationDay> presentationDays = new ArrayList<>();
            while (resultSet.next())
            {
                presentationDays.add(new PresentationDay(resultSet.getInt("Duration"), resultSet.getDate("StartTime"),
                        resultSet.getDate("EndTime")));
            }
            resultSet.close();
            return presentationDays;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void create(CreatePresentationDay request)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/webtechdb","root","buda123");
                Statement statement = connection.createStatement())
        {
            statement.execute(
                    "INSERT INTO webtechdb.presentationday (Duration,StartTime,EndTime) VALUE(" + request.getDuration() + ",'"
                            + format.format(request.getStartTime()) + "','" + format.format(request.getEndTime()) + "')");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
