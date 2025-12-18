package frontistirio11.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 4 from the slides: collision resolution on hashing.
 *
 * The slide deck mentions the topic but doesn't include full code; this demo shows two common strategies:
 *  1) Separate chaining
 *  2) Linear probing (open addressing)
 */
public class Example05_HashCollisionResolution implements Example {

    @Override
    public String title() {
        return "Hashing: collision resolution (chaining vs linear probing)";
    }

    private static int hash(int key, int m) {
        // Keep it simple for a demo
        int h = key % m;
        return h < 0 ? h + m : h;
    }

    private static class ChainingHashTable {
        private final List<Integer>[] buckets;

        @SuppressWarnings("unchecked")
        ChainingHashTable(int capacity) {
            buckets = (List<Integer>[]) new List[capacity];
            for (int i = 0; i < capacity; i++) {
                buckets[i] = new ArrayList<Integer>();
            }
        }

        void add(int key) {
            int i = hash(key, buckets.length);
            buckets[i].add(key);
        }

        boolean contains(int key) {
            int i = hash(key, buckets.length);
            return buckets[i].contains(key);
        }

        void print() {
            for (int i = 0; i < buckets.length; i++) {
                System.out.println(i + " -> " + buckets[i]);
            }
        }
    }

    private static class LinearProbingHashTable {
        private final Integer[] table;

        LinearProbingHashTable(int capacity) {
            table = new Integer[capacity];
        }

        void add(int key) {
            int m = table.length;
            int i = hash(key, m);

            for (int step = 0; step < m; step++) {
                int idx = (i + step) % m;
                if (table[idx] == null) {
                    table[idx] = key;
                    return;
                }
            }
            throw new IllegalStateException("Hash table is full");
        }

        boolean contains(int key) {
            int m = table.length;
            int i = hash(key, m);

            for (int step = 0; step < m; step++) {
                int idx = (i + step) % m;
                if (table[idx] == null) return false;        // stop early
                if (table[idx].intValue() == key) return true;
            }
            return false;
        }

        void print() {
            for (int i = 0; i < table.length; i++) {
                System.out.println(i + " -> " + table[i]);
            }
        }
    }

    @Override
    public void run() {
        int[] keys = new int[] { 10, 21, 32, 43, 54, 65, 76 }; // many collide if capacity is small
        int capacity = 5;

        System.out.println("Separate chaining (capacity=" + capacity + "):");
        ChainingHashTable c = new ChainingHashTable(capacity);
        for (int k : keys) c.add(k);
        c.print();

        System.out.println();
        System.out.println("Linear probing (capacity=" + capacity + "):");
        LinearProbingHashTable lp = new LinearProbingHashTable(capacity);
        // Only insert first 5 to avoid 'full' in this small demo
        for (int i = 0; i < 5; i++) lp.add(keys[i]);
        lp.print();

        System.out.println();
        System.out.println("contains(43) chaining=" + c.contains(43) + ", linear=" + lp.contains(43));
        System.out.println("contains(999) chaining=" + c.contains(999) + ", linear=" + lp.contains(999));
    }
}
