package dao;

import beans.CreatePresentation;
import beans.GetPresentations;
import beans.Presentation;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class PresentationDAO {
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public List<Presentation> getAll(GetPresentations request) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/webtechdb", "root", "buda123");
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM webtechdb.presentation WHERE webtechdb.presentation.PresentationDay=" + request.getPresentationDay() + "");
            List<Presentation> result = new ArrayList<>();
            while (resultSet.next()) {

                try {
                    result.add(new Presentation(resultSet.getInt("ID"), resultSet.getString("FN"), resultSet.getString("PresentationDay"), format.parse(resultSet.getString("StartTime"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
            resultSet.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void create(CreatePresentation request) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/webtechdb", "root", "buda123");
             Statement statement = connection.createStatement()) {
            SimpleDateFormat formater = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
            try {
                statement.executeUpdate(
                        "INSERT INTO webtechdb.presentation (FN, StartTime, PresentationDay)  VALUES (" + request.getFn() + ",'" + format.format(formater.parse(request
                                .getStartTime())) + "'," + request.getPresentationDay() + ")");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
