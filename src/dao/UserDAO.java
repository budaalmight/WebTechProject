package dao;

import beans.LoginUser;
import beans.RegisterUser;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class UserDAO
{
    public String checkUserCredentials(LoginUser user)
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

            ResultSet result = statement.executeQuery(
                    "SELECT * FROM webtechdb.student WHERE FN=" + user.getUsername() + " AND Password='" + user.getPassword()
                            + "'");
            if( result.next() && result.getString("Fn").equals(user.getUsername()) && result.getString("Password").equals(user.getPassword()))
            {
                return SessionProvider.nextSessionId();
            }
            else
                return "Error";
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "Error";
    }

    public void createUser(RegisterUser user)
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
            statement.execute(
                    "INSERT INTO webtechdb.student (Name, FN, Email, Password) VALUE('" + user.getName() + "'," + user.getUsername() + ",'"
                            + user.getEmail() + "','" + user.getPassword() + "')");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
