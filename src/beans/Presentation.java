package beans;

import java.util.Date;

public class Presentation
{
    private final String fn;
    private final String presentationDay;
    private final long startTime;

    public Presentation(String fn, String presentationDay, Date startTime)
    {
        this.fn = fn;
        this.presentationDay = presentationDay;
        this.startTime = startTime.getTime();
    }

    public String getFn()
    {
        return fn;
    }

    public String getPresentationDay()
    {
        return presentationDay;
    }

    public long getStartTime()
    {
        return startTime;
    }
}
