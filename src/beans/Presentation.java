package beans;

import java.util.Date;

public class Presentation
{


    private final int id;
    private final String fn;
    private final String presentationDay;
    private final long startTime;

    public Presentation(int id, String fn, String presentationDay, Date startTime)
    {
        this.id = id;
        this.fn = fn;
        this.presentationDay = presentationDay;
        this.startTime = startTime.getTime();
    }

    public int getId() {
        return id;
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
