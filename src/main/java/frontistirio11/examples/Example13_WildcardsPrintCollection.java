package frontistirio11.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Based on slides "Type Wildcards", "1st Naive Try with Generics", and "Correct way - Use Wildcards".
 */
public class Example13_WildcardsPrintCollection implements Example {

    @Override
    public String title() {
        return "Wildcards: printCollection(Collection<?>)";
    }

    // Old-style version from the slides (raw types).
    private static void printCollectionRaw(Collection c) {
        Iterator i = c.iterator();
        for (int k = 0; k < c.size(); k++) {
            System.out.println(i.next());
        }
    }

    // Correct generic version.
    private static void printCollection(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        List<String> strings = new ArrayList<String>();
        strings.add("a");
        strings.add("b");

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);

        System.out.println("Raw version prints strings:");
        printCollectionRaw(strings);

        System.out.println("Wildcard generic version prints ints:");
        printCollection(ints);

        // This would NOT compile (as per the slide), so it's commented:
        // void printCollection(Collection<Object> c) { ... }
        // because List<String> is not a Collection<Object>.
    }
}
