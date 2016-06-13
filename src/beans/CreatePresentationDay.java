package beans;

public class CreatePresentationDay extends PresentationDay
{
    private final String sid;

    public CreatePresentationDay(String sid, String date, String duration, String startTime, String endTime)
    {
        super(date,duration,startTime,endTime);
        this.sid = sid;
    }

    public String getSid()
    {
        return sid;
    }
}
