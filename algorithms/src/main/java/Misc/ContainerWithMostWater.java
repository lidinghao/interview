package Misc;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by lihao on 16/4/27.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int h = (height[i] < height[j]) ? height[i] : height[j];
            max = Math.max(max, (j - i) * h);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    @Test
    public void test() {
        Assert.assertEquals(21, maxArea(new int[]{7,5,6,9}));
        Assert.assertEquals(1, maxArea(new int[]{2,1}));
    }
}
