package LinkedList;

import org.junit.Test;

import java.util.List;

/**
 * Created by lihao on 16/5/2.
 */
public class RemoveElements {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeElements(ListNode head, int val) {

        ListNode prev = null, walk = head;
        while(walk!=null){
            if (walk.val == val) {
                walk = walk.next;
                if (prev == null) {
                    head = walk;
                } else {
                    prev.next = walk;
                }

            } else {
                prev= walk;
                walk=walk.next;
            }
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {

        if (head==null) return null;
        while (head!=null&& head.val==val)
            head = head.next;
        ListNode walk = head;
        while (walk != null && walk.next != null) {
            if (walk.next.val == val)
                walk.next = walk.next.next;
            else
                walk=walk.next;
        }
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode front = dummy;
        ListNode behind = dummy;
        while (--n >= 0) {
            front=front.next;
        }
        while (front.next != null) {
            front = front.next;
            behind = behind.next;
        }
        behind.next= behind.next.next;
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;

        //ListNode list = removeElements(head, 1);
        ListNode list2 = removeNthFromEnd(head, 3);
        while (list2 != null) {
            System.out.println(list2.val);
            list2 = list2.next;
        }


    }
}
