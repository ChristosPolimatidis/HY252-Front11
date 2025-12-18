package frontistirio11.examples;

import java.util.Stack;

/**
 * Example 3 from the slides: evaluating postfix (RPN) expressions using a stack.
 *
 * Input format here: tokens separated by spaces (e.g., "34 22 2 * +").
 * Supports +, -, *, / operators with integer arithmetic.
 */
public class Example04_PostfixExpressionEvaluator implements Example {

    @Override
    public String title() {
        return "Stack: Evaluate postfix (RPN) expressions";
    }

    private int evalPostfix(String expr) {
        Stack<Integer> st = new Stack<Integer>();
        String[] toks = expr.trim().split("\\s+");

        for (String tok : toks) {
            if (tok.length() == 0) continue;

            if (isOperator(tok)) {
                if (st.size() < 2) {
                    throw new IllegalArgumentException("Not enough operands before operator: " + tok);
                }
                int b = st.pop();
                int a = st.pop();
                st.push(apply(a, b, tok.charAt(0)));
            } else {
                st.push(Integer.parseInt(tok));
            }
        }

        if (st.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression (stack size " + st.size() + ")");
        }
        return st.pop();
    }

    private boolean isOperator(String tok) {
        return tok.length() == 1 && "+-*/".indexOf(tok.charAt(0)) >= 0;
    }

    private int apply(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    @Override
    public void run() {
        // From the slide table (same results):
        String[] examples = new String[] {
                "34",
                "34 22 +",
                "34 22 2 * +",
                "34 22 * 2 +",
                "34 22 + 2 *"
        };

        for (String ex : examples) {
            int v = evalPostfix(ex);
            System.out.println(ex + "  =  " + v);
        }
    }
}
