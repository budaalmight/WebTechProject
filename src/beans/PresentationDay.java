package beans;

public class PresentationDay
{
    private final String date;
    private final String duration;
    private final String startTime;
    private final String endTime;

    public PresentationDay(String date, String duration, String startTime, String endTime)
    {
        this.date = date;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDate()
    {
        return date;
    }

    public String getDuration()
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
