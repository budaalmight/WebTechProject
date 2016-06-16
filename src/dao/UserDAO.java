package dao;

import beans.LoginUser;
import beans.RegisterUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class UserDAO
{
    public String checkUserCredentials(LoginUser user)
    {
        boolean hasUser;
        List<Map<String, String>> execute = DatabaseConnector
                .execute("SELECT * FROM STUDENT WHERE FN='" + user.getUsername() + "' AND PASSWORD='" + user.getUsername() + "'");
        hasUser = execute.get(0).get("FN") != null && !execute.get(0).get("FN").equals("") && execute.get(0).get("FN")
                .equals(user.getUsername()) && execute.get(0).get("PASSWORD").equals(user.getPassword());
        if (hasUser)
        {
            return SessionProvider.nextSessionId();
        }
        else
            return "Error";
    }

    public void createUser(RegisterUser user)
    {

        DatabaseConnector.execute(
                "INSERT INTO STUDENT (NAME, FN, EMAIL, PASSWORD) VALUES('" + user.getName() + "','" + user.getUsername() + "','"
                        + user.getEmail() + "','" + user.getPassword() + "')");
    }
}
