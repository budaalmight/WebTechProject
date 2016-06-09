package dao;

import java.sql.*;

public class DatabaseConnector
{
    private static Connection c;
    static
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\WebTechProject\\WebTechProjectDB");
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println("Opened database successfully");
    }
    public static synchronized Statement getStatement(){
        try
        {
            return c.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
