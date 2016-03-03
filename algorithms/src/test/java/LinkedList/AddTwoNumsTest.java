package LinkedList;

import org.junit.Test;

import static LinkedList.AddTwoNums.*;
import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/3/3.
 */
public class AddTwoNumsTest {

    @Test
    public void testAddTwoNumbers() throws Exception {
        AddTwoNums.ListNode listNode = new AddTwoNums.ListNode(1);
        ListNode listNode2 = listNode.next;
        listNode2 = new ListNode(3);
        System.out.println(listNode2.val);
        System.out.println(listNode.next.val);

    }
}