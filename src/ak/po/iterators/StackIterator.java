package ak.po.iterators;

import ak.po.interfaces.IteratorInterface;
import ak.po.interfaces.StackInterface;

import java.util.Stack;

public class StackIterator implements IteratorInterface
{
    StackInterface stack = null;
    int current;
    public StackIterator(StackInterface s)
    {
        stack = s;
        current = 0;
        first();
    }
    public void previous()
    {
        current--;
    }
    public void next()
    {
        current++;
    }
    public void first()
    {
        current = 1;
    }
    public void last()
    {
        current = stack.size();
    }
    public boolean isDone()
    {
        return current <= 0 || current > stack.size();
    }
    public Object current() throws IndexOutOfBoundsException {
        return stack.getItem(current);
    }
}
