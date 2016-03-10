package Sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/3/10.
 */
public class MedianOfTwoArraysTest {

    @Test
    public void testFindMedianSortedArrays() throws Exception {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{4, 5,6};
        double median = MedianOfTwoArrays.findMedianSortedArrays(nums1, nums2);
        assertEquals(3.5,median,0.001);

    }
}