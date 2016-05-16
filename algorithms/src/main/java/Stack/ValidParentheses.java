package Stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by mandy on 2016/5/11.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (!stack.isEmpty() && isPair(stack.peek(), ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }

    public boolean isPair(char left, char right) {
        switch (left) {
            case '(':
                return right == ')';
            case '{':
                return right == '}';
            case '[':
                return right == ']';
            default:
                return false;
        }
    }

    @Test
    public void test() {
        Assert.assertTrue(isValid("(){}[]"));
        Assert.assertTrue(isValid("{()}[]"));
        Assert.assertFalse(isValid(")(}[]"));
    }
}
