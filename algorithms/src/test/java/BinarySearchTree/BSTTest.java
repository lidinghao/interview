package BinarySearchTree;

import org.junit.Test;

import java.util.AbstractCollection;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/1/6.
 */
public class BSTTest {

    @Test
    public void testGet() throws Exception {
        BST<Integer, Integer>  bst = new BST<Integer, Integer>();
        Integer[] array = new Integer[]{20,2, 8, 4,85,93,75,8,4,50,39, 5};
        for (Integer integer : array) {
            bst.put(integer, integer + 2);
        }
        for (Integer integer : array) {
            assertEquals(bst.get(integer),Integer.valueOf(integer + 2) );
        }
        assertNull(bst.get(10));

    }

    @Test
    public void testPut() throws Exception {
        BST<Integer, Integer>  bst = new BST<Integer, Integer>();
        Integer[] array = new Integer[]{2, 8, 4, 9, 5};
        for (Integer integer : array) {
            bst.put(integer, integer + 2);
        }
    }
}