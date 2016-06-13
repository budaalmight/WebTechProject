package beans;

public class CreateComment
{
    private final String fn;
    private final  String comment;
    private final String presentation;
    private final String sid;

    public CreateComment(String fn, String comment, String presentation, String sid)
    {
        this.fn = fn;
        this.comment = comment;
        this.presentation = presentation;
        this.sid = sid;
    }

    public String getFn()
    {
        return fn;
    }

    public String getComment()
    {
        return comment;
    }

    public String getPresentation()
    {
        return presentation;
    }

    public String getSid()
    {
        return sid;
    }
}
