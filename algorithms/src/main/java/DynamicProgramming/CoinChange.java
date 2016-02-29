package DynamicProgramming;

/**
 * Created by mandy on 2016/2/18.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int k = count(coins, coins.length, amount);
        if (k == 0) {
            return -1;
        } else {
            return k;
        }
    }

    public int count(int[] coins, int m, int n) {
        if (n==0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else if (m <= 0 && n >=1) {
            return 0;
        }
        return count(coins, m - 1, n) + count(coins, m, n - coins[m - 1]);
    }

    public int memoizedCoinChange(int[] coins, int amount) {
        return 0;
    }

    public int bottomUpCoinChange(int[] coins, int amount) {
        int[] table = new int[amount+1];
        for (int i = 0; coins[0]*i <= amount ; i++) {
            table[coins[0]*i] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            int left = 0;
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0 ) {
                    left = table[j - coins[i]];

                }
                table[j] = table[j] + left;


            }
        }
        return table[amount];
    }


}
