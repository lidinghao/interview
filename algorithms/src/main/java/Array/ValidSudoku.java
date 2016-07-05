package Array;

/**
 * Created by lihao on 16/6/13.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            fillFalse(used);
            for (int j = 0; j < 9; j++) {
                char k = board[i][j];
                if (!check(used,k)) return false;
            }
            fillFalse(used);
            for (int j = 0; j < 9; j++) {
                char k = board[j][i];
                if (!check(used,k)) return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkSubbox(board, i, j)) return false;
            }
        }
       return  true;
    }
    public void fillFalse(boolean[] used) {
        for (int i = 0; i < used.length; i++) {
            used[i] = false;

        }
    }

    public boolean check(boolean[] used, char ch) {
        if (ch == '.') return true;
        if (used[ch - '1']) return false;
        else {
            used[ch - '1'] = true;
            return true;
        }
    }
    public boolean checkSubbox(char[][] board, int i, int j) {
        boolean[] used = new boolean[9];
        for (int p = i * 3; p < i * 3 + 3; p++) {
            for (int q = j * 3; q < j * 3 + 3; q++) {
                char k = board[p][q];
                if (!check(used,k)) return false;
            }
        }
        return true;
    }
}
