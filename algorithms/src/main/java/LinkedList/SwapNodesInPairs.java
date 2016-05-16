package LinkedList;

import org.junit.Test;

/**
 * Created by mandy on 2016/5/13.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode first = dummy.next;
        while (first!= null && first.next != null) {
            prev.next = first.next;
            first.next = first.next.next;
            prev.next.next = first;

            prev=first;
            first = first.next;
        }
        return dummy.next;
    }
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
