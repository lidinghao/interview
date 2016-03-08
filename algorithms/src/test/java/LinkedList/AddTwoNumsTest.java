package LinkedList;

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import static LinkedList.AddTwoNums.*;
import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/3/3.
 */
public class AddTwoNumsTest {

    @Test
    public void testAddTwoNumbers() throws Exception {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);


        ListNode l3 = AddTwoNums.addTwoNumbers(l1, l2);
        assertEquals(2, l3.val);
        assertEquals(2, l3.next.val);
        assertEquals(3, l3.next.next.val);
        assertEquals(1, l3.next.next.next.val);

    }

    @Test
    public void testAddTwoNums() throws Exception {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);


        ListNode l3 = AddTwoNums.addTwoNums(l1, l2);
        assertEquals(2, l3.val);
        assertEquals(2, l3.next.val);
        assertEquals(3, l3.next.next.val);
        assertEquals(1, l3.next.next.next.val);
    }
}