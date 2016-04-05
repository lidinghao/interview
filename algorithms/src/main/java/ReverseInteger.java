import org.junit.Test;

/**
 * Created by mandy on 2016/3/26.
 */
public class ReverseInteger {

    public int reverse(int x) {
        long r = 0;
        long t = x;
        boolean sign = x >= 0 ? false : true;
        t = sign? -x: x;
        for (; t > 0 ; t = t/10) {
            r = r*10 + t%10;
        }
        Long maxSign = new Long(Integer.MAX_VALUE) +1;
        if ((!sign &&r > Integer.MAX_VALUE) || (sign && r > maxSign)) {
            return 0;
        } else {
            return sign ? (int) -r : (int) r;
        }
    }
    @Test
    public void  test() {
        System.out.println(reverse(-123));

    }
}
