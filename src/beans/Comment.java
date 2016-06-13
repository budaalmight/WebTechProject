package beans;

public class Comment
{
    private final String presentation;
    private final String fn;
    private final String comment;

    public Comment(String presentation, String fn, String comment)
    {
        this.presentation = presentation;
        this.fn = fn;
        this.comment = comment;
    }

    public String getPresentation()
    {
        return presentation;
    }

    public String getFn()
    {
        return fn;
    }

    public String getComment()
    {
        return comment;
    }
}
