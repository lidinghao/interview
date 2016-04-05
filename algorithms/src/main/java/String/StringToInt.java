package String;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

/**
 * Created by mandy on 2016/4/5.
 */
public class StringToInt {
    public static int myAtoi(String str) {
      int i = 0;
        int len = str.length();
        if (len==0) return 0;
        while (i < len && str.charAt(i) ==' ') i++;
        int sign = 1;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            i++;
            sign = -1;
        }
        int num = 0;
        for (;i< len;i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            if (num > Integer.MAX_VALUE / 10 ||
                    (num == Integer.MAX_VALUE /10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return sign == -1? Integer.MIN_VALUE : Integer.MAX_VALUE;

            }
            num = num * 10 + str.charAt(i) - '0';
        }
        return num * sign;
    }
    @Test
    public void test() {
        Assert.assertEquals(-123, myAtoi("-123"));
        Assert.assertEquals(243, myAtoi("+243"));
        Assert.assertEquals(2147483647, myAtoi("2147483648"));
        Assert.assertEquals(-2147483648, myAtoi("-2147483648"));
        Assert.assertEquals(-2147483648, myAtoi("    -2147483648"));
    }
}
