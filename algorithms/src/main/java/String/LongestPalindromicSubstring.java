package String;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by mandy on 2016/3/10.
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        final  int n = s.length();
        final char[] chars = s.toCharArray();
        final boolean[][] table = new boolean[n][n];
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (j == i - 1) {
                    table[j][i] = (chars[j] == chars[i]);
                } else {
                    table[j][i] = (chars[j] == chars[i]) && table[j + 1][i - 1];
                }
                if (table[j][i] && maxLen < (i - j + 1)) {
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


}
