import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mandy on 2016/3/26.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if ((nums.length < 3)) {
            return result;
        }
        for (int i = 0; i <= nums.length-2; i++) {
            //避免由于有相同元素，导致重复
            if (i> 0 && nums[i]==nums[i-1]) continue;

            int target = 0 - nums[i];
            //设置两个指针，然后根据求和结果，逐步逼近
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {

                if (nums[k] + nums[j] > target){
                    //如果和大于target,则右边的指针左进一步
                    k--;
                    while (nums[k] == nums[k+1] && j < k) --k;
                } else if (nums[k] + nums[j] < target) {
                    //如果和小于target,则左边的指针右进一步
                    j++;
                    while (nums[j] == nums[j-1]&& j < k) j++;
                }else {
                    //如果相等，则加入list
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (nums[j] == nums[j-1]&& j < k) j++;
                    while (nums[k] == nums[k+1]&& j < k) --k;
                }
            }

        }
        return result;
    }
}
