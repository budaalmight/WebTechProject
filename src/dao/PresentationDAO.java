package dao;

import beans.CreatePresentation;
import beans.GetPresentations;
import beans.Presentation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PresentationDAO
{
    public List<Presentation> getAll(GetPresentations request){
        try
        {
            ResultSet result = DatabaseConnector.getStatement().executeQuery("SELECT * FROM PRESENTATION WHERE PRESENTATIONDAY='" + request.getPresentationDay() + "'");
            List<Presentation> presentations = new ArrayList<>();
            presentations.add(new Presentation(result.getString("STUDENT"),result.getString("PRESENTATIONDAY"),result.getString("STARTTIME"),result.getString("COMMENTS")));
            while(result.next()){
                presentations.add(new Presentation(result.getString("STUDENT"),result.getString("PRESENTATIONDAY"),result.getString("STARTTIME"),result.getString("COMMENTS")));
            }
            return presentations;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public boolean create(CreatePresentation request){
        try
        {
            return DatabaseConnector.getStatement().execute("INSERT INTO PRESENTATION VALUES ("+ request.getFn() +"," + request.getPresentationDay() +"," + request.getStartTime() +")");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
