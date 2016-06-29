package beans;


import java.util.Date;

public class PresentationDay
{
    private final String id;
    private final Integer duration;
    private final Long startTime;
    private final Long endTime;

    public PresentationDay(String id, Integer duration, Date startTime, Date endTime)
    {
        this.id=id;
        this.duration = duration;
        this.startTime = startTime.getTime();
        this.endTime = endTime.getTime();

    }
    public String getId() {
        return id;
    }

    public Integer getDuration()
    {
        return duration;
    }

    public Long getStartTime()
    {
        return startTime;
    }

    public Long getEndTime()
    {
        return endTime;
    }
}
