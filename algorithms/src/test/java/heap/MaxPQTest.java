package heap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/1/3.
 */
public class MaxPQTest {

    @Test
    public void testInsert() throws Exception {

        MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
        for (int i = 1; i <= 5 ; i++) {
            maxPQ.insert(i);
            assertFalse(maxPQ.isEmpty());
        }
    }

    @Test
    public void testMax() throws Exception {
        MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
        for (int i = 1; i <= 5 ; i++) {
            maxPQ.insert(i);
            assertEquals(maxPQ.max(),Integer.valueOf(i));
        }

        MaxPQ<Integer> maxPQ2 = new MaxPQ<Integer>(4);
        for (int i = 4; i >= 1 ; i--) {
            maxPQ2.insert(i);
            assertEquals(maxPQ2.max(),Integer.valueOf(4));
        }

        MaxPQ<Integer> maxPQ3 = new MaxPQ<Integer>(5);
        Integer[] array = new Integer[]{2, 8, 4, 9, 5};
        Integer max = 2;
        for (Integer i: array){
            maxPQ3.insert(i);
            max = Math.max(max, i);
            assertEquals(maxPQ3.max(), max);

        }

    }

    @Test
    public void testDelMax() throws Exception {

//        MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
//        for (int i = 1; i <= 5 ; i++) {
//            maxPQ.insert(i);
//            assertEquals(maxPQ.delMax(),Integer.valueOf(i));
//        }

        MaxPQ<Integer> maxPQ2 = new MaxPQ<Integer>(5);
        for (int i = 3; i >= 1 ; i--) {
            maxPQ2.insert(i);
        }
        for (int i = 3; i >= 1 ; i--) {
            assertEquals(maxPQ2.delMax(),Integer.valueOf(i));
        }
        MaxPQ<Integer> maxPQ3 = new MaxPQ<Integer>(5);
        Integer[] array = new Integer[]{2, 8, 4, 9, 5};
        Integer[] sortedArray = new Integer[]{9,8,5,4,2};
        Integer max = 2;
        for (Integer i: array){
            maxPQ3.insert(i);
        }
        for (Integer i:sortedArray) {

            assertEquals(maxPQ3.delMax(), i);

        }





    }

    @Test
    public void testIsEmpty() throws Exception {
        MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
        assertTrue(maxPQ.isEmpty());
        for (int i = 1; i <= 5 ; i++) {
            maxPQ.insert(i);
            assertFalse(maxPQ.isEmpty());
        }

    }

    @Test
    public void testSize() throws Exception {
        MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
        assertEquals(maxPQ.size(), 0);
        for (int i = 1; i <= 5 ; i++) {
            maxPQ.insert(i);
            assertEquals(maxPQ.size(),i);
        }
        for (int i = 5; i >= 1 ; i--) {
            maxPQ.delMax();
            assertEquals(maxPQ.size(),i-1);
        }

    }
}