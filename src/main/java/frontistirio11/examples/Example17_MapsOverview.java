package frontistirio11.examples;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Bonus overview demo (useful for the lecture + fills menu to 17).
 */
public class Example17_MapsOverview implements Example {

    @Override
    public String title() {
        return "Maps overview: HashMap vs LinkedHashMap vs TreeMap";
    }

    @Override
    public void run() {
        int[] values = new int[] { 1, 2, 3, 4, 5 };

        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        Map<Integer, Integer> linked = new LinkedHashMap<Integer, Integer>();
        Map<Integer, Integer> tree = new TreeMap<Integer, Integer>();

        for (int j : values) {
            int k = j % 3; // like the exam slide
            hash.put(k, j);
            linked.put(k, j);
            tree.put(k, j);
        }

        System.out.println("After putting (k=j%3, v=j) for j=1..5:");
        System.out.println("HashMap      (no order guarantee): " + hash);
        System.out.println("LinkedHashMap(insertion order):   " + linked);
        System.out.println("TreeMap      (sorted by key):     " + tree);

        System.out.println("\nValues (TreeMap): " + tree.values());
        System.out.println("Keys   (TreeMap): " + tree.keySet());
    }
}
