package beans;

import java.util.Date;

public class Presentation
{
    private final String fn;
    private final String presentationDay;
    private final Date startTime;

    public Presentation(String fn, String presentationDay, Date startTime)
    {
        this.fn = fn;
        this.presentationDay = presentationDay;
        this.startTime = startTime;
    }

    public String getFn()
    {
        return fn;
    }

    public String getPresentationDay()
    {
        return presentationDay;
    }

    public Date getStartTime()
    {
        return startTime;
    }
}
