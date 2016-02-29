package DynamicProgramming;

/**
 * Created by mandy on 2016/2/22.
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int[][] table = new int[m][n];
        table[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            table[i][0] = grid[i][0] + table[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            table[0][i] = grid[0][i] + table[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int min = Math.min(table[i - 1][j], table[i][j - 1]);
                table[i][j] = grid[i][j] + min;
            }
        }
        return table[m-1][n-1];
    }

    public int minPathSum2(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int[] table = new int[n];
        table[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            table[i] = grid[0][i] + table[i - 1];
        }

        for (int i = 1; i < m; i++) {
            table[0] = table[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                int min = Math.min(table[j - 1], table[j]);
                table[j] = grid[i][j] + min;
            }
        }
        return table[n-1];
    }
}
