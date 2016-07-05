package Search;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by lihao on 16/6/9.
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length -1]) return nums.length;
         int lo= 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2 ;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return  lo ;
    }
    @Test
    public void test() {
        Assert.assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assert.assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assert.assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
        Assert.assertEquals(0, searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
