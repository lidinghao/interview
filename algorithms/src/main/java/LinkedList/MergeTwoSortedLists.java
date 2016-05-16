package LinkedList;

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * Created by mandy on 2016/5/11.
 */
public class MergeTwoSortedLists {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        cur.next = l1 != null ? l1 : l2;

        return head.next;
    }


    @Test
    public void test() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        ListNode list = mergeTwoLists(l1, l2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }

    }
}
