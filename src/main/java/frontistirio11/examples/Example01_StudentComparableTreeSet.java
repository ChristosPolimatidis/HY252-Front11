package frontistirio11.examples;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Based on slide "Example 1: Comparing your own Objects" (Comparable + TreeSet).
 * Students are sorted by score (ascending).
 */
public class Example01_StudentComparableTreeSet implements Example {

    // Raw Comparable (as in the slides) to match the Java 1.8 era examples.
    private static class Student implements Comparable {
        private final String name;
        private final int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Object o) throws ClassCastException {
            if (o instanceof Student) {
                return this.score - ((Student) o).score;
            }
            throw new ClassCastException("Not a Student!");
        }
    }

    @Override
    public String title() {
        return "Comparable + TreeSet (Students sorted by score)";
    }

    @Override
    public void run() {
        TreeSet set = new TreeSet();
        set.add(new Student("Giorgos", 87));
        set.add(new Student("Manos", 83));
        set.add(new Student("Ilias", 99));
        set.add(new Student("Nikos", 25));
        set.add(new Student("Ioanna", 76));

        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            Student s = (Student) iter.next();
            System.out.println(s.name + " " + s.score);
        }
    }
}
