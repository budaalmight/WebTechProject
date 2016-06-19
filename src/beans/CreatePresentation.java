package beans;

import java.util.Date;

public class CreatePresentation
{
    private final String sid;
    private final String fn;
    private final Date startTime;
    private final String presentationDay;

    public CreatePresentation(String sid, String fn, Date startTime, String presentationDay)
    {
        this.sid = sid;
        this.fn = fn;
        this.startTime = startTime;
        this.presentationDay = presentationDay;
    }

    public String getSid()
    {
        return sid;
    }

    public String getFn()
    {
        return fn;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public String getPresentationDay()
    {
        return presentationDay;
    }
}
