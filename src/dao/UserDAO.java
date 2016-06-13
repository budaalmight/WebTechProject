package dao;

import beans.LoginUser;
import beans.RegisterUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO
{
    public String checkUserCredentials(LoginUser user)
    {
        boolean hasUser = false;
        Statement statement = DatabaseConnector.getStatement();
        try
        {
            ResultSet set = statement.executeQuery(
                    "SELECT * FROM STUDENT WHERE FN='" + user.getUsername() + "' AND PASSWORD='" + user.getUsername() + "'");
            hasUser = set.getString("FN") != null && !set.getString("FN").equals("") && set.getString("FN")
                    .equals(user.getUsername()) && set.getString("PASSWORD").equals(user.getPassword());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        if (hasUser)
        {
            return SessionProvider.nextSessionId();
        }
        else
            return "Error";
    }

    public boolean createUser(RegisterUser user)
    {
        Statement statement = DatabaseConnector.getStatement();
        try
        {

            return statement.execute(
                    "INSERT INTO STUDENT VALUE(" + user.getName() + "," + user.getUsername() + "," + user
                            .getEmail() + "," + user.getPassword() + ")");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
