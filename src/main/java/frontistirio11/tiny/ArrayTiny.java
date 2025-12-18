package frontistirio11.tiny;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Based on slides: "Array Implementation of Tiny", "Cloning", and the iterator slides.
 */
public class ArrayTiny extends AbstractTiny implements Tiny, Cloneable {

    public static final int DEFAULT_CAPACITY = 100;

    private final Object[] items;

    public ArrayTiny() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayTiny(int capacity) {
        super();
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        items = new Object[capacity];
    }

    @Override
    public void add(Object obj) {
        if (isFull()) {
            throw new IllegalStateException("Can't add, Array full");
        }
        items[size] = obj;
        size++;
        modCount++;
    }

    @Override
    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public Object removeLast() {
        if (size == 0) {
            throw new IllegalStateException("Can't remove, empty");
        }
        size--;
        modCount++;
        Object removed = items[size];
        items[size] = null; // avoid loitering
        return removed;
    }

    @Override
    public Object clone() {
        // Shallow copy (same element references), like the slide mentions.
        ArrayTiny copy = new ArrayTiny(items.length);
        for (int i = 0; i < this.size; i++) {
            copy.items[i] = this.items[i];
        }
        copy.size = this.size;
        // modCount intentionally not copied (fresh collection)
        return copy;
    }

    @Override
    public Iterator iterator() {
        return new InnerIter();
    }

    private class InnerIter implements Iterator {
        private int curPos = 0;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return curPos < size;
        }

        @Override
        public Object next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            curPos++;
            return items[curPos - 1];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove not supported");
        }
    }
}
