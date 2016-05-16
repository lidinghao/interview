import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by mandy on 2016/5/16.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length()==0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (!stack.isEmpty() && chars[stack.peek()] == '(') {
                stack.pop();
                int curLen = 0;
                if (!stack.isEmpty()) {
                    curLen = i - stack.peek();
                } else {
                    curLen = i + 1;
                }
                maxLen = Math.max(maxLen, curLen);
            } else {
                stack.push(i);
            }
        }
         return maxLen;
    }

    @Test
    public void test() {
        String s = "()(()";
        Assert.assertEquals(2, longestValidParentheses(s));
    }
}
