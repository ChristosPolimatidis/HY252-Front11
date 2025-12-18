package frontistirio11.examples;

import frontistirio11.stack.ArrayStack;
import frontistirio11.tiny.LinkedTiny;
import frontistirio11.tiny.Tiny;

/**
 * Based on slide "Example: Tiny to Stack".
 */
public class Example08_TinyToArrayStackConversion implements Example {

    @Override
    public String title() {
        return "Conversion: Tiny -> ArrayStack (using iterator)";
    }

    @Override
    public void run() {
        Tiny tiny = new LinkedTiny();
        tiny.add("A");
        tiny.add("B");
        tiny.add("C");

        ArrayStack stack = new ArrayStack(((LinkedTiny) tiny).iterator());
        System.out.println("Tiny size=" + tiny.size());
        System.out.println("ArrayStack from Tiny.iterator() -> " + stack);

        System.out.println("Popping (LIFO):");
        while (!stack.isEmpty()) {
            System.out.println("  pop -> " + stack.pop());
        }
    }
}
