package LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lihao on 16/4/30.
 */
public class LinkedListCycle2 {
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        boolean hasCycle = false;
        ListNode slow= head, fast = head;
        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle==false)
            return null;
        fast = head;
        while (fast!= slow) {
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = head;
        Assert.assertTrue(detectCycle(head)==head);

        node2.next = null;
        Assert.assertTrue(detectCycle(head)==null);
    }
}
