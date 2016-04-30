package LinkedList;

import junit.framework.Assert;
import org.junit.Test;
import sun.jvm.hotspot.ui.table.SortHeaderMouseAdapter;

/**
 * Created by lihao on 16/4/30.
 */
public class LinkedListsIntersection {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null)
            return null;
        int l = 1, m = 1;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA.next != null) {
            l++;
            pA = pA.next;
        }
        while (pB.next != null) {
            m++;
            pB = pB.next;
        }
        if (pA!=pB)
            return null;

        ListNode fast = l > m ? headA : headB;
        ListNode slow = l > m ? headB : headA;
        int d = Math.abs(l-m);
        while (d -- > 0)
            fast=fast.next;
        while (fast != slow) {
            fast=fast.next;
            slow= slow.next;
        }
        return fast;
    }

    @Test
    public void test() {
        ListNode headA = new ListNode(1);
        ListNode node2 = new ListNode(2);
        headA.next=node2;
        ListNode head3 = new ListNode(3);
        node2.next=head3;
        ListNode head4 = new ListNode(4);
        head3.next=head4;
        ListNode headB = new ListNode(5);
        headB.next = head3;

        Assert.assertTrue(getIntersectionNode(headA,headB)==head3);
        headB.next=null;
        Assert.assertTrue(getIntersectionNode(headA,headB)==null);

    }

}
