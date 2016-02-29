package DynamicProgramming;

/**
 * Created by mandy on 2016/2/18.
 */
public class MinCoinChange {

    public int coinChange(int[] coins, int amount) {
//        double k = recursiveCount(coins, coins.length, amount);
//        if (k >= Double.POSITIVE_INFINITY) {
//            return -1;
//        } else {
//            return (int) k;
//        }

        return dpCount(coins, amount);
    }

    public double recursiveCount(int[] coins, int m, int n) {
        if (n==0) {
            return 0;
        } else if (n < 0) {
            return Double.POSITIVE_INFINITY;
        } else if (m <= 0 && n >=1) {
            return Double.POSITIVE_INFINITY;
        }
        return Math.min(recursiveCount(coins, m-1, n) , recursiveCount(coins, m, n-coins[m-1]) + 1);
    }

    public int dpCount(int[] coins, int n) {
        int m = coins.length;
        int[][] table = new int[m][n + 1];
        for (int i = 1; i <= n ; i++) {
            table[0][i] = Integer.MAX_VALUE;
            if (i - coins[0] >= 0 && table[0][i - coins[0]] != Integer.MAX_VALUE) {
                table[0][i] = table[0][i-coins[0]] + 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                int left;
                if (j - coins[i] >= 0 && table[i][j - coins[i]] != Integer.MAX_VALUE) {
                    left = table[i][j - coins[i]] + 1;
                } else {
                    left = Integer.MAX_VALUE;
                }

                int up = table[i-1][j];
                table[i][j] = Math.min(left, up);
            }
        }
        return table[m-1][n] != Integer.MAX_VALUE ? table[m-1][n] : -1;
    }
    public int compressedDpCount(int[] coins, int n) {
        int m = coins.length;
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i - coins[0] >= 0 && array[i - coins[0]] != Integer.MAX_VALUE) {
                array[i] = array[i - coins[0]] + 1;

            } else {
                array[i] = Integer.MAX_VALUE;
            }

        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                int left ;
                if (j - coins[i] >= 0 && array[j - coins[i]] != Integer.MAX_VALUE) {
                    left = array[j - coins[i]] + 1;
                } else {
                    left = Integer.MAX_VALUE;
                }
                //滚动更新，利用了两个特性：
                // 1.当前行肯定比上一行要更优，因为多了一种硬币，就多一种选择，不会比上一行差
                // 2.从左到右计算，所以可以滚动，覆盖更新
                //当前值就是up值
                int up = array[j];
                array[j] = Math.min(left, up);
            }

        }
        return array[n] != Integer.MAX_VALUE ? array[n] : -1;
    }

    //每种面值只能使用一次。
    public int minCoinChange3(int[] coins, int amount) {

        int m = coins.length;
        int max = Integer.MAX_VALUE;
        int[][] table = new int[m][amount + 1];
        for (int i = 1; i <= amount; i++) {
            if (i == coins[0]) {
                table[0][i] = 1;
            } else {
                table[0][i] = max;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= amount; j++) {
                int leftup = max;
                if ((j - coins[i]) >= 0 && table[i-1][j-coins[i]] != max) {
                    leftup = table[i - 1][j-coins[i]] + 1;
                }
                    table[i][j] = Math.min(leftup, table[i-1][j]);

            }
        }
        int result = table[m - 1][amount];
        return result != max ? result : -1;
    }

    //
    public int minCoinChange4(int[] coins, int amount) {
        int[] table = new int[amount+1];
        int max = Integer.MAX_VALUE;

        for (int i = 1; i <= amount; i++) {
            if (i == coins[0]) {
                table[i] = 1;
            } else {
                table[i] = max;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            //由于依赖的是左上，所以要注意倒着覆盖
            // (int j = 1; j <= amount; j++)
            for (int j = 1; j <= amount; j++) {
                int leftup = max;
                if (j - coins[i] >= 0 && table[j - coins[i]] != max) {
                    leftup = table[j-coins[i]] + 1;
                }

                table[j] = Math.min(leftup, table[j]);
            }
        }
        return table[amount];
    }
}
