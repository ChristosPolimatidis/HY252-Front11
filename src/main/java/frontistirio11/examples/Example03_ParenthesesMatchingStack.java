package frontistirio11.examples;

import java.util.Stack;

/**
 * Based on slide "Parentheses Matching Java code" (Stack).
 */
public class Example03_ParenthesesMatchingStack implements Example {

    @Override
    public String title() {
        return "Stack: Matching parentheses";
    }

    // Same logic as the slide, with minor modernizations (Character boxing is automatic in Java 8).
    private boolean inputOk(String s) {
        Stack<Character> stack = new Stack<Character>();
        boolean match = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    match = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            match = false;
        }

        return match;
    }

    @Override
    public void run() {
        String[] tests = new String[] {
                "a",
                "ab",
                "(a)",
                "((a))",
                "(a(b)c)",
                "()",
                "(()))",
                "a(",
                ")(",
                "a)",
                "((())"
        };

        for (String t : tests) {
            System.out.printf("%-8s -> %s%n", t, inputOk(t) ? "OK" : "NOT OK");
        }
    }
}
