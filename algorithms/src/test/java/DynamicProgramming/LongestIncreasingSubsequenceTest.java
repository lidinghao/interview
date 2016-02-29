package DynamicProgramming;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/2/24.
 */
public class LongestIncreasingSubsequenceTest {

    int[] seq = null;
    int[] seq2 = null;
    LongestIncreasingSubsequence lis = null;

    @Before
    public void setUp() throws Exception {
        seq = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        seq2= new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        lis = new LongestIncreasingSubsequence();
    }

    @Test
    public void testLengthOfLIS() throws Exception {
        int len = lis.lengthOfLIS(seq);
        int len2 = lis.lengthOfLIS(seq2);
        assertEquals(5, len);
        assertEquals(4, len2);

    }

    @Test
    public void testGetTable() throws Exception {
        int[] table = lis.getTable(seq);
        int[] subSeq = lis.generateLIS(table, seq);
        int[] expect = new int[]{1,3,4,8,9};
        assertArrayEquals(expect, subSeq);

    }

    @Test
    public void testGenerateLIS() throws Exception {

    }

    @Test
    public void testGetTable2() throws Exception {
        int[] table = lis.getTable2(seq);
        int[] subSeq = lis.generateLIS(table, seq);
        int[] expect = new int[]{1,3,4,8,9};
        assertArrayEquals(expect, subSeq);
    }
}