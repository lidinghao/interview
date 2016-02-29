package DynamicProgramming;

/**
 * Created by mandy on 2016/2/24.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] table = getTable(nums);
        int len = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] > len) {
                len = table[i];
            }
        }
        return len;
    }

    public int[] getTable(int[] nums) {
        int[] table = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            table[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    table[i] = Math.max(table[i], table[j] + 1);
                }
            }
        }
        return table;
    }
    public int[] getTable2(int[] nums) {
        int[] table = new int[nums.length];
        int[] statsTable = new int[nums.length];
        int statsTablelimit = 0;
        statsTable[0]=nums[0];
        table[0] = 1;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
               l = 0;
               r = statsTablelimit;

            while (r >= l) {
                m = (l + r) / 2;
                if (nums[i] > statsTable[m]) {
                    l = m + 1;
                } else {
                    r= m -1;
                }
            }

            statsTablelimit = Math.max(statsTablelimit, l);
            statsTable[l] = nums[i];
            table[i] = l+1;
           }
        return table;

        }




    public int[] generateLIS(int[] table, int[] num) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] > len) {
                len = table[i];
                index = i;
            }
        }
        int lastIndex = index;
        int[] lis = new int[len];
        lis[--len] = num[index];
        for (int i = index - 1; i >= 0; i--) {
            if (table[i] == table[lastIndex] -1 && num[i] < num[lastIndex]) {
                lastIndex = i;
                lis[--len] = num[i];
            }
        }
        return lis;

    }
}
