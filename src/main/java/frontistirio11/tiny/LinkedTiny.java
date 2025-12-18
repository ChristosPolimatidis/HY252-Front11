package frontistirio11.tiny;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple linked-list implementation of Tiny (mentioned in the slides as LinkedTiny).
 * Not capacity-bound (so isFull() always returns false).
 */
public class LinkedTiny extends AbstractTiny implements Tiny {

    private static class Node {
        Object value;
        Node next;

        Node(Object v) { value = v; }
    }

    private Node head;
    private Node tail;

    public LinkedTiny() {
        super();
    }

    /**
     * Convenience constructor used by the slides: create a Tiny from an iterable (e.g., a Stack).
     */
    public LinkedTiny(Iterable<?> xs) {
        this();
        if (xs != null) {
            for (Object x : xs) {
                add(x);
            }
        }
    }

    @Override
    public void add(Object obj) {
        Node n = new Node(obj);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
        modCount++;
    }

    @Override
    public Object removeLast() {
        if (size == 0) {
            throw new IllegalStateException("Can't remove, empty");
        }
        modCount++;
        size--;

        if (head == tail) {
            Object v = head.value;
            head = null;
            tail = null;
            return v;
        }

        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        Object v = tail.value;
        prev.next = null;
        tail = prev;
        return v;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new InnerIter();
    }

    private class InnerIter implements Iterator {
        private Node cur = head;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Object next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (cur == null) {
                throw new NoSuchElementException("No more elements");
            }
            Object v = cur.value;
            cur = cur.next;
            return v;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove not supported");
        }
    }
}
