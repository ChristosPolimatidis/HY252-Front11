package frontistirio11.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on slide "Generics and Subtyping".
 */
public class Example12_GenericsSubtyping implements Example {

    @Override
    public String title() {
        return "Generics: subtyping (List<String> is NOT a List<Object>)";
    }

    @Override
    public void run() {
        List<String> ls = new ArrayList<String>();
        ls.add("hello");

        // This assignment is NOT allowed (compile-time error), so it is commented:
        // List<Object> lo = ls;

        // Correct alternatives:
        List<?> lo1 = ls; // "list of unknown"
        List<? extends Object> lo2 = ls; // also ok

        System.out.println("ls = " + ls);
        System.out.println("lo1 size = " + lo1.size());
        System.out.println("lo2 first element = " + lo2.get(0));

        // You cannot add to lo1/lo2 (except null), because element type is unknown:
        // lo1.add(new Object()); // compile-time error
    }
}
