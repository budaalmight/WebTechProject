package beans;

import java.util.Date;

public class CreatePresentationDay extends PresentationDay
{
    private final String sid;

    public CreatePresentationDay(String sid, Integer duration, Date startTime, Date endTime)
    {
        super(duration,startTime,endTime);
        this.sid = sid;
    }

    public String getSid()
    {
        return sid;
    }
}
