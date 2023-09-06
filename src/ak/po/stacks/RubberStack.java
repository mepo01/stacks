package ak.po.stacks;

import ak.po.exceptions.EmptyStackException;
import ak.po.exceptions.FullStackException;
import ak.po.interfaces.StackInterface;
import ak.po.iterators.StackIterator;

public class RubberStack implements StackInterface
{
    private Object array[];
    private int size;

    public RubberStack(int maxSize)
    {
        if (maxSize < 0) {
            maxSize *= -1;
        }
        array = new Object[maxSize];
        size = 0;
    }

    @Override
    public void push(Object value) {
        double Capacity75 = array.length * 0.75;
        if(size < Capacity75) {
            array[size] = value;
            size++;
        } else {
            expand();
            array[size] = value;
            size++;
        }
    }

    public void expand() {
        Object expanded[] = new Object[array.length*2];
        for (int i = 0; i < size; i++) {
            expanded[i] = array[i];
        }
        array = expanded;
    }
    @Override
    public Object pop() {
        Object item = null;
        if(empty())
        {
            throw new EmptyStackException("Stos jest pusty");
        } else if (size-1 <= array.length*0.25){
            reduce();
            item = array[size-1];
            array[size-1] = null;
            size--;
        } else {
            item = array[size-1];
            array[size-1] = null;
            size--;
        }
        return item;
    }

    public void reduce() {
        if(array.length > 1) {
            int newsize = (int) (array.length * 0.5);
            Object reduced[] = new Object[newsize];
            for (int i = 0; i < size; i++) {
                reduced[i] = array[i];
            }
            array = reduced;
        } else {
            System.out.println("Stos osiągnął już minimalny rozmiar");
        }
    }

    @Override
    public Object peek() {
        Object item = null;
        if (!empty()) {
            item = array[size-1];
        } else {
            throw new EmptyStackException("Stos jest pusty");
        }
        return item;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Object[] getArray() {
        return array;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public Object getItem(int index) {
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
