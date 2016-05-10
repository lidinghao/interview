package Array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by mandy on 2016/5/9.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int closetSum = nums[0] + nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int abs = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    int closet = Math.abs(closetSum - target);
                    closetSum = closet < abs ? closetSum : nums[i] + nums[j] + nums[k];
                }
            }
        }
        return closetSum;

    }
    public int threeSumClosestV2(int[] nums, int target) {
        int result = 0;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1, k = nums.length-1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int gap = Math.abs(sum - target);
                if (minGap > gap) {
                    result = sum;
                    minGap = gap;
                }
                if (sum < target) j++;
                else k--;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        Assert.assertEquals(2,threeSumClosestV2(nums, 1));
    }
}
