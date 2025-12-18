package frontistirio11.examples;

import frontistirio11.tiny.ArrayTiny;
import frontistirio11.tiny.Tiny;

public class Example06_TinyArrayImplementation implements Example {

    @Override
    public String title() {
        return "Tiny: ArrayTiny (add/removeLast/isFull)";
    }

    @Override
    public void run() {
        Tiny tiny = new ArrayTiny(3);

        tiny.add("A");
        tiny.add("B");
        tiny.add("C");

        System.out.println("size=" + tiny.size() + ", isFull=" + tiny.isFull());
        System.out.println("removeLast -> " + tiny.removeLast());
        System.out.println("removeLast -> " + tiny.removeLast());
        System.out.println("size=" + tiny.size() + ", isFull=" + tiny.isFull());

        tiny.add("D");
        System.out.println("size=" + tiny.size() + ", isFull=" + tiny.isFull());
    }
}
