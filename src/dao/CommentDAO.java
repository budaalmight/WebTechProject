package dao;

import beans.Comment;
import beans.CreateComment;
import beans.GetAllComments;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommentDAO
{
    public String createComment(CreateComment comment)
    {
        DatabaseConnector.execute(
                "INSERT INTO COMMENT (PRESENTATION,FN,COMMENT) VALUES ('" + comment.getPresentation() + "','" + comment.getFn()
                        + "','" + comment.getComment() + "')");
        return "Done";
    }

    public List<Comment> getAllComments(GetAllComments request)
    {
        List<Map<String, String>> result = DatabaseConnector
                .execute("SELECT * FROM COMMENT WHERE PRESENTATION='" + request.getPresentation() + "'");
        return result.stream().map(line -> new Comment(line.get("PRESENTATION"), line.get("STUDENT"), line.get("COMMENT")))
                .collect(Collectors.toList());
    }
}
