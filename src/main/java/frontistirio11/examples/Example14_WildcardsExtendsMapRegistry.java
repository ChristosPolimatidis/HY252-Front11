package frontistirio11.examples;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Based on slide "Using Wildcards Again" (Map<String, ? extends Person>).
 */
public class Example14_WildcardsExtendsMapRegistry implements Example {

    static class Person {
        private final String name;

        Person(String name) { this.name = name; }

        @Override
        public String toString() { return getClass().getSimpleName() + "(" + name + ")"; }
    }

    static class Driver extends Person {
        private final String license;

        Driver(String name, String license) {
            super(name);
            this.license = license;
        }

        @Override
        public String toString() {
            return super.toString() + " license=" + license;
        }
    }

    static class Census {
        public static void addRegistry(Map<String, ? extends Person> registry) {
            System.out.println("Registry entries:");
            for (Map.Entry<String, ? extends Person> e : registry.entrySet()) {
                System.out.println("  " + e.getKey() + " -> " + e.getValue());
            }

            // Can't do registry.put("x", new Person("p")) because of "? extends Person"
        }
    }

    @Override
    public String title() {
        return "Wildcards: Map<String, ? extends Person>";
    }

    @Override
    public void run() {
        Map<String, Driver> allDrivers = new LinkedHashMap<String, Driver>();
        allDrivers.put("AM-123", new Driver("Maria", "B"));
        allDrivers.put("BB-999", new Driver("Nikos", "C"));

        Census.addRegistry(allDrivers);
    }
}
