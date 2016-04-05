package BackTracking;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by mandy on 2016/3/26.
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (findWord(board, visited, word,i, j, 0)) return true;
            }
        }
        return false;
    }

    public static boolean findWord(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        if (k==word.length() ) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n ||visited[i][j]|| board[i][j] != word.charAt(k)) {
            return false;

        }

        visited[i][j] = true;
        if (findWord(board, visited, word, i, j + 1, k + 1)
                || findWord(board, visited, word, i, j - 1, k + 1)
                || findWord(board, visited, word, i + 1, j, k + 1)
                || findWord(board, visited, word, i - 1, j, k + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    @Test
    public void test() {
        int m = 3;
        int n = 4;
        char[][] board = new char[m][n];
        String str  =
        "ABCE"+
        "SFCS"+
        "ADEE";

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(i * 4 + j);
            }
        }

        Assert.assertEquals(true, exist(board, "ABCCED"));
        Assert.assertEquals(true, exist(board, "SEE"));
        Assert.assertEquals(false, exist(board, "ABCB"));
    }
}
