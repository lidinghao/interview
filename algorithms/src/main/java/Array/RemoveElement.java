package Array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mandy on 2016/5/14.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int id = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[id++] = val;
            }
        }
        return id;
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 2, 3};
        Assert.assertEquals(2, removeElement(nums, 3));
        int[] nums2 = {3, 3, 3, 2};
        Assert.assertEquals(1, removeElement(nums, 3));

    }
}
