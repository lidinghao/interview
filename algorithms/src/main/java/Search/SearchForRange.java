package Search;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by lihao on 16/6/2.
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length -1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid]< target)
                lo = mid + 1;
            else
                hi = mid;
        }
        int left;
        if(nums[lo] != target)
            return new int[] {-1,-1};
        else
            left = lo;
        hi = nums.length -1;
        while (lo < hi) {
            int mid = (lo + hi) / 2+1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return new int[]{left, lo};
    }
    public int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length -1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid -1;
            }
        }
        return -1;
    }
    public int greaterSearch(int[] nums, int target) {
        int lo = 0, hi = nums.length -1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, greaterSearch(new int[]{1, 2, 5, 8, 11}, 3));
        Assert.assertEquals(2, binarySearch(new int[]{1, 2, 5, 8, 11}, 5));
        Assert.assertEquals(-1, binarySearch(new int[]{1, 2, 5, 8, 11}, 3));
    }
}
