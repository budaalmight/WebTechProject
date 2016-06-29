package beans;

public class Presentation
{
    private final String fn;
    private final String presentationDay;
    private final String startTime;

    public Presentation(String fn, String presentationDay, String startTime)
    {
        this.fn = fn;
        this.presentationDay = presentationDay;
        this.startTime = startTime;
    }

    public String getFn()
    {
        return fn;
    }

    public String getPresentationDay()
    {
        return presentationDay;
    }

    public String getStartTime()
    {
        return startTime;
    }
}
