import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/3/26.
 */
public class ThreeSumTest {

    @Test
    public void testThreeSum() throws Exception {
        ThreeSum sum = new ThreeSum();
        List<List<Integer>> list = sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> expected = new ArrayList<>();
        Assert.assertEquals(2, list.size());

        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.println(integer);
            }
        }
    }
}