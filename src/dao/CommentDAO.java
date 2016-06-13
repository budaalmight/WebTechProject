package dao;

import beans.Comment;
import beans.CreateComment;
import beans.GetAllComments;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CommentDAO
{
    public String createComment(CreateComment comment){
        Statement statement = DatabaseConnector.getStatement();
        try
        {
            ResultSet resultSet = statement.executeQuery("INSERT INTO COMMENT VALUES ("+comment.getPresentation()+"," +  comment.getFn() +","+comment.getComment() +","+")");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "Done";
    }
    public List<Comment> getAllComments(GetAllComments request){
        return null;
    }
}
