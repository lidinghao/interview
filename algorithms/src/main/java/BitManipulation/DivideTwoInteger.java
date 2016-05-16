package BitManipulation;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by mandy on 2016/5/15.
 */
public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        int sign = (( dividend<0) ^ (divisor <0))  ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        long result = 0;
        while (dvd > dvs) {
            long temp = dvs;
            for (int i = 0; dvd >= temp; i++, temp <<= 1) {
                dvd -= temp;
                result += 1<<i;
            }
        }
        result = sign*result > Integer.MAX_VALUE ? Integer.MAX_VALUE : sign*result;
        return (int) result ;
    }

    @Test
    public void test() {
        Assert.assertEquals(2,divide(-2147483648,-1));
    }
}
