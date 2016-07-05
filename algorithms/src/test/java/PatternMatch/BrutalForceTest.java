package PatternMatch;

/**
 * Created by mandy on 2015/11/30.
 */
import org.junit.Assert;
import org.junit.Test;
public class BrutalForceTest  {
    @Test
    public void testBrutalForce(){
        BrutalForce bf = new BrutalForce();
        String text = "abcdefg";
        String pattern1 = "cde";
        String pattern2 = "ab";
        String pattern3 = "fg";
        String pattern4 = "h";
        Assert.assertEquals(3,bf.match(text,pattern1));
        Assert.assertEquals(1,bf.match(text,pattern2));
        Assert.assertEquals(6,bf.match(text,pattern3));
        Assert.assertEquals(0,bf.match(text,pattern4));

    }

}
