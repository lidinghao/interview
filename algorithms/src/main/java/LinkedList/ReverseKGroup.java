package LinkedList;

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * Created by mandy on 2016/5/13.
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head ==null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = prev;
        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            prev = reverse(prev, prev.next, end);
            end = prev;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode prev, ListNode begin, ListNode end) {
        ListNode  end_next = end.next;
        for (ListNode p = begin, cur = p.next, next = cur.next;
                cur != end_next;
                p = cur, cur = next, next = next != null ? next.next : null) {
                  cur.next = p;

         }
        begin.next = end_next;
        prev.next = end;
        return begin;
    }
    public ListNode reverseKGroupV2(ListNode head, int k) {
        if (head ==null || head.next == null || k < 2) return head;
        ListNode next_group_head = head;
        for (int i = 0; i < k; i++) {
            if (next_group_head!= null) {
                next_group_head = next_group_head.next;
            }else
                return head;

        }
        ListNode new_next_group_head = reverseKGroupV2(next_group_head, k);
        ListNode prev = null, cur = head;
        while (cur != next_group_head) {
            ListNode next = cur.next;
            cur.next = prev == null ? new_next_group_head : prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        head = reverseKGroupV2(head,2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
