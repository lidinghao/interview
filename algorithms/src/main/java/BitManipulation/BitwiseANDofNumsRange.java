package BitManipulation;

/**
 * Created by mandy on 2016/5/6.
 */
public class BitwiseANDofNumsRange {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n &= n -1;
        }
        return n;
    }
}
