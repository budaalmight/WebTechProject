package beans;


public class PresentationDay
{
    private final String id;
    private final Integer duration;
    private final String startTime;
    private final String endTime;

    public PresentationDay(String id, Integer duration, String startTime, String  endTime)
    {
        this.id=id;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getId() {
        return id;
    }

    public Integer getDuration()
    {
        return duration;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }
}
