package frontistirio11.examples;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Bonus overview demo (useful for the lecture + fills menu to 17).
 */
public class Example16_SetsOverview implements Example {

    @Override
    public String title() {
        return "Sets overview: HashSet vs LinkedHashSet vs TreeSet";
    }

    @Override
    public void run() {
        int[] xs = new int[] { 7, 3, 7, 1, 9, 3, 2 };

        Set<Integer> hash = new HashSet<Integer>();
        Set<Integer> linked = new LinkedHashSet<Integer>();
        Set<Integer> tree = new TreeSet<Integer>();

        for (int x : xs) {
            hash.add(x);
            linked.add(x);
            tree.add(x);
        }

        System.out.println("Input: 7,3,7,1,9,3,2");
        System.out.println("HashSet      (no order guarantee): " + hash);
        System.out.println("LinkedHashSet(insertion order):   " + linked);
        System.out.println("TreeSet      (sorted order):      " + tree);
    }
}
