package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;

class DatabaseConnector
{
    static synchronized List<Map<String, String>> execute(String query)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager
                    .getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\WebTechProject\\WebTechProjectDB");
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Map<String, String>> result = new ArrayList<>();
            while (resultSet.next())
            {
                Map<String, String> line = new HashMap<>();
                for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++)
                {
                    line.put(resultSet.getMetaData().getColumnName(i), resultSet.getString(i));
                }
                result.add(line);
            }
            statement.close();
            c.close();
            return result;
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
