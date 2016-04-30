package String;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by lihao on 16/4/25.
 */
public class RegExprMatch {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int i, String p, int j) {
        if (j==p.length()) {
            return i == s.length();
        }
        char c = p.charAt(j);
        //p中下一个字符不为'*'
        if (j == p.length() - 1 || p.charAt(j+1)!= '*') {
            if (i < s.length() && (c == s.charAt(i) || c == '.'))
                return isMatch(s, i + 1, p, j + 1);
            else
                return false;
        } else {
            while (i < s.length() && (c == s.charAt(i) || c == '.')) {
                if (isMatch(s, i,p,j+2)){
                    return true;
                }
                i++;
            }
            return isMatch(s, i, p, j+2);
        }
    }
    @Test
    public void test() {
        Assert.assertFalse(isMatch("aa","a"));
        Assert.assertTrue(isMatch("aa","aa"));
        Assert.assertFalse(isMatch("aaa","aa"));
        Assert.assertTrue(isMatch("aa", "a*"));
        Assert.assertTrue(isMatch("aa", ".*"));
        Assert.assertTrue(isMatch("ab", ".*"));
        Assert.assertTrue(isMatch("aab", "c*a*b"));
    }
}
