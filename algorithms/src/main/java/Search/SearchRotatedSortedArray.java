package Search;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by lihao on 16/5/23.
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target == nums[mid]) return mid;
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
      return -1;
    }
    @Test
    public void test() {
        Assert.assertEquals(1,search(new int[]{3,1},1));
    }
}
