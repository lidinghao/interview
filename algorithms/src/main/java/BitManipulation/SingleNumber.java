package BitManipulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mandy on 2016/5/5.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
    public int singleNumber2(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int num : nums) {
            two |= one & num;
            one = one ^ num;
            three  = one & two ;
            one &= ~three;
            two &= ~three;
        }
        return one != 0 ? one:two;
    }

    public int[] singleNumber3(int[] nums) {
        int result  = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        int k = 0;
        for (; k < Integer.SIZE; k++) {
            if (((result >>> k)&1) == 1) {
                break;
            }
        }
        int x = 0;
        for (int num : nums) {
            if (((num >>> k) & 1) == 1) {
                x ^= num;
            }
        }
        return new int[]{x, x ^ result};
    }
    @Test
    public void test() {
        Assert.assertEquals(3, singleNumber(new int[]{1, 2, 3, 2, 1}));
        Assert.assertEquals(2, singleNumber(new int[]{1, 2, 1}));
        Assert.assertEquals(2, singleNumber2(new int[]{1, 2, 1, 1}));
        Assert.assertEquals(5, singleNumber2(new int[]{1, 2, 5, 5, 1, 2, 2, 1}));
        Assert.assertArrayEquals(new int[]{3,5}, singleNumber3(new int[]{1, 2, 5, 1, 2, 3}));
        Assert.assertArrayEquals(new int[]{3,1}, singleNumber3(new int[]{1, 2, 5, 2,5, 3}));
    }
}
