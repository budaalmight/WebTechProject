package beans;

import java.util.Date;

public class PresentationDay
{
    private final Integer duration;
    private final Date startTime;
    private final Date endTime;

    public PresentationDay(Integer duration, Date startTime, Date endTime)
    {
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getDuration()
    {
        return duration;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
}
