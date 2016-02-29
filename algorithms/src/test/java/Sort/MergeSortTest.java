package Sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/1/4.
 */
public class MergeSortTest {

    @Test
    public void testSort() throws Exception {
        Integer[] array = new Integer[]{2,5,3,8,4,9};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        for (Integer integer : array) {
            System.out.println(integer);
        }

    }
    @Test
    public void testButtomUpSort() {
        Integer[] array = new Integer[]{2,5,3,8,4,9};
        MergeSort mergeSort = new MergeSort();
        mergeSort.ButtomUpSort(array);
        for (Integer integer : array) {
            System.out.println(integer);
        }
    }
}