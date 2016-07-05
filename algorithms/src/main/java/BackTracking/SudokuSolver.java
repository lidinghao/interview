package BackTracking;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by lihao on 16/6/14.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);

    }

    public static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        board[i][j] = k;
                        if (isValid(board, i, j) && solve(board))
                            return true;
                        else
                            board[i][j] = '.';
                    }
                    return false;
                }

            }
        }
        //当最终求得正确解时,会走到这一段代码,因为所有的空格都被填满,所以if语句不会被执行。
        return true;

    }

    public static boolean isValid(char[][] board, int i, int j) {
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][col] == board[i][j])
                return false;
        }
        for (int row = 0; row < 9; row++) {
            if (row != i && board[row][j] == board[i][j])
                return false;
        }
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if ((row != i || col != j) && board[row][col] == board[i][j])
                    return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String[] str = {"..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.."};
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            char[] chars = str[i].toCharArray();
            for (int j = 0; j < 9; j++) {
                board[i][j] = chars[j];
            }

        }
        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


}
