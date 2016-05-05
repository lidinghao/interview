package Misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mandy on 2016/5/5.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count  = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    major = nums[i];
                    count = 1;
                }
            }
        }
        return major;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, majorityElement(new int[]{1,2,3,4,5,3,3,3,3,3}));
        Assert.assertEquals(5, majorityElement(new int[]{6,5, 5}));
    }
}
