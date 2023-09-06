package ak.po.stacks;

import ak.po.exceptions.EmptyStackException;
import ak.po.exceptions.FullStackException;
import ak.po.interfaces.StackInterface;
import ak.po.iterators.StackIterator;

public class ArrayStack implements StackInterface
{
    private Object array[];
    private int size;

    public ArrayStack(int maxSize)
    {
        if (maxSize < 0) {
            maxSize *= -1;
        }
        array = new Object[maxSize];
        size = 0;
    }

    @Override
    public void push(Object value)
    {
        if(size < array.length) {
            array[size] = value;
            size++;
        }
        else
            throw new FullStackException("Stos jest pełen");
    }

    @Override
    public Object pop()
    {
        Object item = null;
        if(empty())
        {
            throw new EmptyStackException("Stos jest pusty");
        }
        else {
            item = array[size-1];
            array[size-1] = null;
            size--;
        }
        return item;
    }

    @Override
    public Object peek()
    {
        Object item = null;
        if (!empty()) {
            item = array[size-1];
        } else {
            throw new EmptyStackException("Stos jest pusty");
        }
        return item;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean empty()
    {
        return size == 0;
    }

    @Override
    public Object getItem(int index)
    {
        if (index <= 0 || index > size()) {
            throw new IndexOutOfBoundsException("Nieprawidłowy indeks");
        }
        return array[index - 1];
    }

    public String toString()
    {
        String buffer = size() + ": ";
        StackIterator it = new StackIterator(this);
        for(it.first(); !it.isDone(); it.next()) {
            buffer += it.current() + ", ";
        }
        return buffer;
    }
}