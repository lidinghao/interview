package Stack;

import java.util.Stack;

/**
 * Created by mandy on 2016/3/2.
 */
public class Calculator {
    public int calculate(String expression) {
        Stack<Integer> valStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();
        char[] tokens = expression.toCharArray();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer buf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    buf.append(tokens[i++]);
                }
                i--;
                valStack.push(Integer.valueOf(buf.toString()));

            } else if (tokens[i] == '('){
                opStack.push(tokens[i]);

            } else if (tokens[i] == ')') {
                while (opStack.peek() != '(') {
                    Integer val = apply(opStack.pop(), valStack.pop(), valStack.pop());
                    valStack.push(val);
                }
                opStack.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '/' || tokens[i] == '*') {
                while (!opStack.empty() && hasHigherPreced(opStack.peek(), tokens[i])) {
                    Integer val = apply(opStack.pop(), valStack.pop(), valStack.pop());
                    valStack.push(val);

                }
                opStack.push(tokens[i]);

            }
        }
        while (!opStack.empty())
            valStack.push(apply(opStack.pop(), valStack.pop(), valStack.pop()));

        return valStack.pop();
    }

    private boolean hasHigherPreced(Character op1, char op2) {
        if (op1 == '(' || op1 == ')')
            return false;
        if ((op2 == '*' || op2 == '/') && (op1 == '+' || op1 == '-'))
            return false;
        else
            return true;
    }

    private Integer apply(Character operator, Integer operand2, Integer operand1) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;

        }
        throw new IllegalArgumentException("illegal operator");
    }
}
