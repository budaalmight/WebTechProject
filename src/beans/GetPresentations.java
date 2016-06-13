package beans;

public class GetPresentations
{
    private final String sid;
    private final String presentationDay;

    public GetPresentations(String sid, String presentationDay)
    {
        this.sid = sid;
        this.presentationDay = presentationDay;
    }

    public String getSid()
    {
        return sid;
    }

    public String getPresentationDay()
    {
        return presentationDay;
    }
}
