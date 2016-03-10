package Sort;

/**
 * Created by mandy on 2016/3/10.
 */
public class MedianOfTwoArrays {
    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];

        if (nums1.length == 0 || nums2.length == 0) {
            nums = nums1.length == 0 ? nums1 : nums2;
        }
        int i =0;
        int j =0;
        int k = 0;
        while (k < len){
            int max ;
            if (i < nums1.length && j < nums2.length) {
                max = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            }else {
                max = i < nums1.length ? nums1[i++] : nums2[j++];
            }
            nums[k++] = max;
        }
        if (len % 2 != 0 ) return nums[len / 2];
        else return (nums[(len / 2) - 1] + nums[len / 2]) / 2.0;
    }
}
