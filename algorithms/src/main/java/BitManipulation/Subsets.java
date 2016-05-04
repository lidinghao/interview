package BitManipulation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mandy on 2016/5/4.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<Integer>());
        Arrays.sort(nums);
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List temp = new LinkedList<>(result.get(i));
                temp.add(num);
                result.add(temp);
            }
        }
        return result;
    }

    public List<List<Integer>> subsetsV2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        //result.add(new LinkedList<Integer>());
        Arrays.sort(nums);
        int numSubsets = (int) Math.pow(2, nums.length);
        for (int i = 0; i < numSubsets; i++) {
            result.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < numSubsets; j++) {
                int index = ((j>>i)&1);
                if (index == 1) {
                    result.get(j).add(nums[i]);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList list = new ArrayList();
        result.add(list);
        list.add(1);
        result.add(list);
        List<List<Integer>> list2 = subsetsV2(new int[]{4, 1,0});
        for (List<Integer> integers : list2) {
            integers.forEach(integer -> System.out.print(integer));
            System.out.println();
        }
    }
}
