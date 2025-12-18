package frontistirio11.examples;

import frontistirio11.tiny.ArrayTiny;

import java.util.Iterator;

public class Example07_TinyCloneAndIterator implements Example {

    @Override
    public String title() {
        return "Tiny: clone() + iterator() + concurrent modification";
    }

    @Override
    public void run() {
        ArrayTiny t = new ArrayTiny(10);
        t.add("zero");
        t.add("one");
        t.add("two");

        System.out.println("Original:");
        printIter(t.iterator());

        ArrayTiny cloned = (ArrayTiny) t.clone();
        System.out.println("Cloned (shallow copy):");
        printIter(cloned.iterator());

        System.out.println("Concurrent modification demo (should throw ConcurrentModificationException):");
        Iterator it = t.iterator();
        System.out.println("first -> " + it.next());
        // Modify while iterating
        t.add("three");
        // next() should detect modification
        System.out.println("second -> " + it.next());
    }

    private void printIter(Iterator it) {
        while (it.hasNext()) {
            System.out.println("  " + it.next());
        }
    }
}
