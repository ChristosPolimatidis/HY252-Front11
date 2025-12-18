package frontistirio11.examples;

import java.util.LinkedList;
import java.util.List;

/**
 * Based on slide "Example 6: List of Lists without Generics".
 * Demonstrates a runtime ClassCastException risk.
 */
public class Example10_ListOfListsWithoutGenerics implements Example {

    @Override
    public String title() {
        return "Lists of lists (NO generics): runtime error demo";
    }

    @Override
    public void run() {
        List ys = new LinkedList();
        ys.add("zero");

        List yss = new LinkedList();
        yss.add(ys);

        String y = (String) ((List) yss.iterator().next()).iterator().next();
        System.out.println("y = " + y);

        System.out.println("Now forcing the 'evil run-time error' (ClassCastException):");
        try {
            Integer z = (Integer) ys.iterator().next();
            System.out.println("z = " + z);
        } catch (ClassCastException ex) {
            System.out.println("Caught: " + ex);
        }
    }
}
