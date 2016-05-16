package Array;

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

/**
 * Created by mandy on 2016/5/11.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, List<int[]>> cache = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (cache.containsKey(sum)) {
                    List<int[]> list = cache.get(sum);
                    list.add(new int[]{i, j});
                } else {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    cache.put(sum, list);
                }
            }
        }
        Set<String> used = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int key = target - nums[i] - nums[j];
                if (!cache.containsKey(key)) {
                    continue;
                }
                for (int[] ints : cache.get(key)) {
                    if (j >= ints[0]) continue;
                    Integer[] solution = {nums[i], nums[j], nums[ints[0]], nums[ints[1]]};
                    if (!used.contains(Arrays.toString(solution))) {
                        used.add(Arrays.toString(solution));
                        List<Integer> list = new ArrayList<>(Arrays.asList(solution));

                        result.add(list);

                    }

                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSumV2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        if (4*min > target || 4*max < target) return result;
        for (int i = 0; i < nums.length -3; i++) {
            if (nums[i] + 3*min > target) return result;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length - 2; j++) {
             if ((nums[i] + 3*nums[j])> target) break;
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int p = j + 1, q = nums.length - 1;
                while (p < q) {
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;
                        while (nums[q] == nums[q + 1] && p<q) q--;
                        while (nums[p] == nums[p-1] && p<q) p++;
                    } else if (sum > target) {
                        q--;
                        while (nums[q] == nums[q + 1] && p<q) q--;
                    } else {
                        p++;
                        while (nums[p] == nums[p-1] && p<q) p++;
                    }
                }


            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSumV2(nums, 0);
        lists.forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}
