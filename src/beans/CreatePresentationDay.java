package beans;

public class CreatePresentationDay
{
    private final String sid;

    public CreatePresentationDay(String sid, Integer duration, String startTime, String endTime) {
        this.sid = sid;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    private final Integer duration;
    private final String startTime;
    private final String endTime;


    public String getSid()
    {
        return sid;
    }
}
