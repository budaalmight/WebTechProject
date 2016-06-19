package dao;

import beans.CreatePresentation;
import beans.GetPresentations;
import beans.Presentation;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PresentationDAO
{
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm");

    public List<Presentation> getAll(GetPresentations request)
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

            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM webtechdb.presentation WHERE PresentationDay=" + request.getPresentationDay() + "");
            List<Presentation> result = new ArrayList<>();
            while (resultSet.next()){
                result.add(new Presentation(resultSet.getString("FN"),resultSet.getString("PresentationDay"),resultSet.getDate("StartTime")));
            }
            resultSet.close();
            return result;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void create(CreatePresentation request)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/webtechdb","root","buda123");
        Statement statement = connection.createStatement())
        {
            statement.executeUpdate(
                    "INSERT INTO webtechdb.presentation (FN, StartTime, PresentationDay)  VALUES (" + request.getFn() + ",'" + format.format(request
                            .getStartTime()) + "'," + request.getPresentationDay() + ")");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
