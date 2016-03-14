package String;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/3/14.
 */
public class LongestPalindromicSubstringTest {

    @Test
    public void testLongestPalindrome() throws Exception {
        String s = LongestPalindromicSubstring.longestPalindrome("abbad");
        assertTrue(s.equals("abba"));
    }
}