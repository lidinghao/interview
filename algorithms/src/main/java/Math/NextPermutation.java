package Math;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mandy on 2016/5/15.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length <= 1) return;
        int i = nums.length -2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
        if (i >= 0) {
        int j = nums.length -1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);

        }
        reverse(nums, i+1, nums.length -1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    @Test
    public void test() {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1,3,2},nums);
    }
}
