package beans;

public class GetAllComments
{
    private final String sid;
    private final String presentation;

    public GetAllComments(String sid, String presentation)
    {
        this.sid = sid;
        this.presentation = presentation;
    }

    public String getSid()
    {
        return sid;
    }

    public String getPresentation()
    {
        return presentation;
    }
}
