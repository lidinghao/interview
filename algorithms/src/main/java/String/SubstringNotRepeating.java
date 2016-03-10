package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by mandy on 2016/3/5.
 */
public class SubstringNotRepeating {
    public static  int lengthOfLongestSubstring(String s) {
        int longest = 0;
       char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Set<Character> charSet = new HashSet();
            for (int j = i; j < chars.length; j++) {
                if (charSet.contains(chars[j]) != true) {
                    charSet.add(chars[j]);
                    longest = Math.max(longest, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return longest;
    }
}
