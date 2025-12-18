package frontistirio11.examples;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Based on the final slide "Exam topic (collections)".
 * Reproduces the code and prints what it prints.
 */
public class Example15_ExamCollectionsQuestion implements Example {

    @Override
    public String title() {
        return "Exam question: Sets + Maps output (A, B, G, D)";
    }

    @Override
    public void run() {
        Set s1 = new TreeSet();
        for (int i = 5; i >= 1; i--) {
            s1.add(i * i);
        }
        System.out.println("\nQuestion A:");
        for (Object o : s1) {
            System.out.print(o + " ");
        }

        Set s2 = new HashSet();
        s2.add(2); s2.add(3); s2.add(4);

        Set s3 = new HashSet(s1);
        s3.removeAll(s2);

        System.out.println("\n\nQuestion B:");
        for (Object o : s3) {
            System.out.print(o + " ");
        }

        Map m1 = new TreeMap();
        for (int j = 1; j <= 5; j++) {
            m1.put(j % 3, j);
        }

        System.out.println("\n\nQuestion G:");
        for (Object o : m1.values()) {
            System.out.print(o + " ");
        }

        System.out.println("\n\nQuestion D:");
        TreeSet s4 = new TreeSet();
        for (Object o : m1.keySet()) {
            s4.add("Elem " + o + "0");
        }
        for (Object o : s4) {
            System.out.print(o + " ");
        }

        System.out.println();
    }
}
