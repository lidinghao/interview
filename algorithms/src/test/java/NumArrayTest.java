import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/1/13.
 */
public class NumArrayTest {

    @Test
    public void testUpdate() throws Exception {
        int[] nums = new int[]{1,3,5};
        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0,2));
        numArray.update(1,2);
        System.out.println(numArray.sumRange(0,2));

    }

    @Test
    public void testSumRange() throws Exception {
        int[] nums = new int[]{18,17,13,19,15,11,20};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(1,2));
        assertTrue(numArray.sumRange(1,2) == 30);

    }

    @Test
    public void testBuild() throws Exception {
        int[] nums = new int[]{18,17,13,19,15,11,20};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(1,2));
        assertTrue(numArray.sumRange(1,2) == 30);


    }
}