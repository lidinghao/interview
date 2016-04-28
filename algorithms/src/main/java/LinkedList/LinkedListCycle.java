package LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mandy on 2016/4/28.
 */
public class LinkedListCycle {
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow= head, fast = head;
        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = head;
        Assert.assertTrue(hasCycle(head));

        node2.next = null;
        Assert.assertFalse(hasCycle(head));
    }

}
