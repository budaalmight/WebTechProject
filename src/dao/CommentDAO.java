package dao;

import beans.Comment;
import beans.CreateComment;
import beans.GetAllComments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO
{
    public String createComment(CreateComment comment)
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
            statement.executeUpdate(
                    "INSERT INTO webtechdb.comment (Presentation,Student,Comment) VALUES (" + comment.getPresentation() + ","
                            + comment.getFn() + ",'" + comment.getComment() + "')");
            return "Done";
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "Error";
    }

    public List<Comment> getAllComments(GetAllComments request)
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
            List<Comment> comments = new ArrayList<>();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM webtechdb.comment WHERE Presentation=" + request.getPresentation() + "");
            while (resultSet.next())
            {
                comments.add(new Comment(resultSet.getString("Presentation"), resultSet.getString("Student"),
                        resultSet.getString("Comment")));
            }
            resultSet.close();
            return comments;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
