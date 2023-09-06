package ak.po.exceptions;

public class EmptyStackException extends RuntimeException
{
    public EmptyStackException(String message)
    {
        super(message);
    }
}