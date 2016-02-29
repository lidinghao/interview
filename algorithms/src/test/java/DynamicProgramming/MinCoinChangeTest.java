package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/2/18.
 */
public class MinCoinChangeTest {

    @Test
    public void testCoinChange() throws Exception {
        MinCoinChange cc = new MinCoinChange();
        int coins[] = new int[]{1, 2, 5};
        int k = cc.coinChange(coins, 11);
        assertEquals(3,k);

        int coins2[] = new int[]{2};
        int k2 = cc.coinChange(coins2, 11);
        assertEquals(-1,k2);
    }

    @Test
    public void testCompressedCoinChange() throws Exception {
        MinCoinChange cc = new MinCoinChange();
        int coins[] = new int[]{1, 2, 5};
        int k = cc.compressedDpCount(coins, 11);
        assertEquals(3,k);

        int coins2[] = new int[]{2};
        int k2 = cc.compressedDpCount(coins2, 11);
        assertEquals(-1,k2);


    }
    @Test
    public void testminCoinChange3() throws Exception {
        MinCoinChange cc = new MinCoinChange();
        int coins[] = new int[]{5, 2, 5, 3};
        int k = cc.minCoinChange3(coins, 10);
        assertEquals(2,k);

        int k2 = cc.minCoinChange3(coins, 15);
        assertEquals(4,k2);


    }

    @Test
    public void testMinCoinChange4() throws Exception {
        MinCoinChange cc = new MinCoinChange();
        int coins[] = new int[]{3, 2, 5, 1};
        int k = cc.minCoinChange4(coins, 10);
        assertEquals(3,k);

        int k2 = cc.minCoinChange4(coins, 15);
      //  assertEquals(4,k2);
    }
}