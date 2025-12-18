package frontistirio11.examples;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Based on slides "Using a Separate Comparator" and "StudentComparator".
 * TreeSet uses an external Comparator to sort Students.
 */
public class Example02_StudentComparatorTreeSet implements Example {

    private static class Student {
        private final String name;
        private final int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    // Raw Comparator to match the slides.
    private static class StudentScoreComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Student) o1).score - ((Student) o2).score;
        }

        // In practice we don't need to override equals here; Object.equals is fine.
    }

    @Override
    public String title() {
        return "Comparator + TreeSet (Students sorted by score)";
    }

    @Override
    public void run() {
        TreeSet set = new TreeSet(new StudentScoreComparator());
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
