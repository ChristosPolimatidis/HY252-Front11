package frontistirio11.examples;

import frontistirio11.stack.ArrayStack;
import frontistirio11.tiny.LinkedTiny;
import frontistirio11.tiny.Tiny;

/**
 * Based on slide "Example: Stack to Tiny".
 */
public class Example09_ArrayStackToLinkedTinyConversion implements Example {

    @Override
    public String title() {
        return "Conversion: ArrayStack -> LinkedTiny";
    }

    @Override
    public void run() {
        ArrayStack stack = new ArrayStack();
        stack.push("first");
        stack.push("second");
        stack.push("third");

        System.out.println("Stack (bottom->top iteration): " + stack);

        Tiny tiny = new LinkedTiny(stack); // uses Iterable constructor
        System.out.println("Tiny created from stack:");
        for (java.util.Iterator it = ((LinkedTiny) tiny).iterator(); it.hasNext(); ) {
            System.out.println("  " + it.next());
        }
    }
}
