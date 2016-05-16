import java.util.ArrayList;
import java.util.List;

/**
 * Created by mandy on 2016/5/11.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String str, int open, int close, int n) {
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }
        if (open < n) {
            backtrack(result, str + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(result, str + ")", open, close + 1, n);
        }

    }


}
