package beans;

import java.util.ArrayList;
import java.util.List;

public class Presentation
{
    private final String fn;
    private final String presentationDay;
    private final String startTime;
    private final List<String> commentsIds;

    public Presentation(String fn, String presentationDay, String startTime, String commentsIds)
    {
        this.fn = fn;
        this.presentationDay = presentationDay;
        this.startTime = startTime;
        List<String> sep = new ArrayList<>();
        commentsIds = commentsIds.replace("[","");
        commentsIds = commentsIds.replace("]","");
        String[] b = commentsIds.split(",");
        for(String s : b){
            sep.add(s.trim());
        }
        this.commentsIds = sep;
    }

    public String getFn()
    {
        return fn;
    }

    public String getPresentationDay()
    {
        return presentationDay;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public List<String> getCommentsIds()
    {
        return commentsIds;
    }
}
