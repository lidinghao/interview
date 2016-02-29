package Sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/1/5.
 */
public class QuickSortTest {

    @Test
    public void testSort() throws Exception {
        Integer[] array = new Integer[]{2,1,3,8,4,7};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        for (Integer integer : array) {

        System.out.println(integer);
        }
    }
}