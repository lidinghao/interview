package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/2/22.
 */
public class MinPathSumTest {

    @Test
    public void testMinPathSum() throws Exception {
       int[][] matrix = new int[][]{
               {1, 3, 5, 9},
               {8, 1, 3, 4},
               {5, 0, 6, 1},
               {8, 8, 4, 0}
       };

        MinPathSum minPathSum = new MinPathSum();
        int k = minPathSum.minPathSum(matrix);
        assertEquals(12, k);
    }
    @Test
    public void testMinPathSum2() throws Exception {
       int[][] matrix = new int[][]{
               {1, 3, 5, 9},
               {8, 1, 3, 4},
               {5, 0, 6, 1},
               {8, 8, 4, 0}
       };

        MinPathSum minPathSum = new MinPathSum();
        int k = minPathSum.minPathSum2(matrix);
        assertEquals(12, k);
    }
}