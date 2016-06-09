package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO
{
    public String checkUserCredentials(String username, String password)
    {
        boolean hasUser = false;
        Statement statement = DatabaseConnector.getStatement();
        try
        {
            ResultSet set = statement.executeQuery("SELECT * FROM STUDENT WHERE FN='" + username + "' AND PASSWORD='" + password + "'");
            hasUser = set.getString("FN") != null && !set.getString("FN").equals("");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        if(hasUser){
            return SessionProvider.nextSessionId();
        }
        else return "Error";
    }

    public void createUser(String fn, String password, String email)
    {

    }
}
