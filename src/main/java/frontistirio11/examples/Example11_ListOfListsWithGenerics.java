package frontistirio11.examples;

import java.util.LinkedList;
import java.util.List;

/**
 * Based on slide "List of Lists with Generics".
 */
public class Example11_ListOfListsWithGenerics implements Example {

    @Override
    public String title() {
        return "Lists of lists (WITH generics): type safety";
    }

    @Override
    public void run() {
        List<String> ys = new LinkedList<String>();
        ys.add("zero");

        List<List<String>> yss = new LinkedList<List<String>>();
        yss.add(ys);

        String y = yss.iterator().next().iterator().next();
        System.out.println("y = " + y);

        // This line (from the slide) would be a COMPILE-TIME error, so it is intentionally commented:
        // Integer z = ys.iterator().next();
    }
}
