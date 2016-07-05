package String;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by lihao on 16/5/7.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        String prefix = strs[0];
        int prefixLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            prefixLen = prefixLen > strs[i].length() ? strs[i].length() : prefixLen;
            int j = 0;
            for (; j < prefixLen; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            prefixLen = j;
        }
        return String.copyValueOf(strs[0].toCharArray(), 0, prefixLen);

    }
    @Test
    public void test() {
        String[] strs = {"1234567","1234","12345678"};
        Assert.assertEquals("1234",longestCommonPrefix(strs));
    }
}
