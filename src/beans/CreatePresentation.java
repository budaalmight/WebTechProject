package beans;

public class CreatePresentation
{
    private final String sid;
    private final String fn;
    private final String startTime;
    private final String presentationDay;

    public CreatePresentation(String sid, String fn, String startTime, String presentationDay)
    {
        this.sid = sid;
        this.fn = fn;
        this.startTime = startTime;
        this.presentationDay = presentationDay;
    }

    public String getSid()
    {
        return sid;
    }

    public String getFn()
    {
        return fn;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public String getPresentationDay()
    {
        return presentationDay;
    }
}
