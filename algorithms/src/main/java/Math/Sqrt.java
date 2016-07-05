package Math;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by lihao on 16/5/2.
 */
public class Sqrt {
    public int newtonSqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x/r)/2;
        }
        return ((int) r);
    }

    public int binSearchSqrt(int x) {
        int low = 1, high = x;
        int mid=0;
        while (low <= high) {
            mid = low + (high -low) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }

    @Test
    public void test() {
        //Assert.assertEquals(10, newtonSqrt(100));
        Assert.assertEquals(10, binSearchSqrt(100));
        Assert.assertEquals(3, binSearchSqrt(9));
        Assert.assertEquals(5, binSearchSqrt(25));

    }
}
