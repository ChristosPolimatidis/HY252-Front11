package frontistirio11.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Simple stack (LIFO) backed by an ArrayList.
 * Mentioned in the slides as ArrayStack.
 */
public class ArrayStack implements Iterable<Object> {

    private final List<Object> xs;

    public ArrayStack() {
        xs = new ArrayList<Object>();
    }

    public ArrayStack(Iterator it) {
        this();
        if (it != null) {
            while (it.hasNext()) {
                push(it.next());
            }
        }
    }

    public void push(Object x) {
        xs.add(x);
    }

    public Object pop() {
        if (xs.isEmpty()) throw new NoSuchElementException("stack is empty");
        return xs.remove(xs.size() - 1);
    }

    public Object peek() {
        if (xs.isEmpty()) throw new NoSuchElementException("stack is empty");
        return xs.get(xs.size() - 1);
    }

    public boolean isEmpty() {
        return xs.isEmpty();
    }

    public int size() {
        return xs.size();
    }

    @Override
    public Iterator<Object> iterator() {
        // Iterate from bottom to top (in insertion order)
        return xs.iterator();
    }

    @Override
    public String toString() {
        return xs.toString();
    }
}
