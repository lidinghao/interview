import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by mandy on 2016/4/8.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        x = Math.abs(x);
        int d = 1; //divisor
        while (x /d >= 10) d *= 10;
        while (x > 0) {
            int q = x / d; // quotient
            int r = x % 10 ; // remainder
            if (q != r) {
                return false;
            }
            x = x % d / 10;
            d /= 100;
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertTrue(isPalindrome(12321));
        Assert.assertTrue(isPalindrome(3));
        Assert.assertFalse(isPalindrome(321));
        Assert.assertFalse(isPalindrome(-2147483648));
        Assert.assertFalse(isPalindrome(-2147447412));
    }
}
