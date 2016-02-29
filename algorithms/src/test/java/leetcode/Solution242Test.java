package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/1/5.
 */
public class Solution242Test {

    @Test
    public void testIsAnagram() throws Exception {
        Solution242 s = new Solution242();
        assertTrue(s.isAnagram("anagram", "nagaram"));
        assertFalse(s.isAnagram("rat", "cat"));
    }
}