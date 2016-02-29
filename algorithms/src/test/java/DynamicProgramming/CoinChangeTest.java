package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/2/18.
 */
public class CoinChangeTest {

    @Test
    public void testCoinChange() throws Exception {
        CoinChange cc = new CoinChange();
        int coins[] = new int[]{1, 2, 5};
        int k = cc.coinChange(coins, 11);
        assertEquals(k, 3);
    }

    @Test
    public void testBottomUpCoinChange() throws Exception {
        CoinChange cc = new CoinChange();
        int coins[] = new int[]{1, 2, 5};
        int k = cc.bottomUpCoinChange(coins, 2);
        assertEquals(2, k);

        int k2 = cc.bottomUpCoinChange(coins, 8);
        assertEquals(7, k2);


    }
}