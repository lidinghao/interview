package leetcode;



import java.util.Arrays;

/**
 * Created by mandy on 2016/1/5.
 */

/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?*/

public class Solution242 {


        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return  false;
            else{
                char[] sChars = s.toCharArray();
                char[] tChars = t.toCharArray();
                Arrays.sort(sChars);
                Arrays.sort(tChars);
                for (int i = 0; i < sChars.length ; i++) {
                    if ( sChars[i] != tChars[i])
                       return false;

                }
            }
            return true;


        }

}
