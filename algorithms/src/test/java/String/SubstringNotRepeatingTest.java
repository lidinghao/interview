package String;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/3/5.
 */
public class SubstringNotRepeatingTest {

    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        int len = SubstringNotRepeating.lengthOfLongestSubstring("abcabcbb");
        assertEquals(3,len);

    }
}