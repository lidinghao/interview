package Array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mandy on 2016/5/14.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int id = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[id-1]) {
                nums[id++] = nums[i];
            }
        }
        return id;

    }
    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        Assert.assertEquals(2, removeDuplicates(nums));
        Assert.assertArrayEquals(new int[]{1,2}, Arrays.copyOf(nums,2));
    }
}
