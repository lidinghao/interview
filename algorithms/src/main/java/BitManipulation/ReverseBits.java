package BitManipulation;

import org.junit.Test;

import java.util.Map;

/**
 * Created by mandy on 2016/5/6.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int result=0;
        for (int i = 0; i < 32; i++) {
            int x = n & 1;
            x = x << (31-i);
            result = result | x;
            n = n >>> 1;
        }
       return result;
    }

    public int reverseBitsV2(int n) {
        for (int i = 0; i < 16; i++) {
            int x = ( n >>> i) & 1;
            int y = ( n >>> 31 - i) & 1;

            if (x != y) {
                n ^= (1 << i) | (1 << 31 - i);
            }
        }
       return n;
    }

    @Test
    public void test() {
        System.out.println(reverseBitsV2(1));
        System.out.println(reverseBitsV2(2));
        System.out.println((int)Math.pow(2,30));
    }
}
