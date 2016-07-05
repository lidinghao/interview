package LinkedList;

import org.junit.Test;

/**
 * Created by lihao on 16/6/2.
 */
public class SwapTwoNodes {
        /**
         * @param head a ListNode
         * @oaram v1 an integer
         * @param v2 an integer
         * @return a new head of singly-linked list
         */
        public ListNode swapNodes(ListNode head, int v1, int v2) {
            // Write your code here
            if(head==null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode prev1 = null;
            ListNode prev2 = null;
            ListNode v1Ptr = null;
            ListNode v2Ptr = null;
            //ListNode node = head;
            while(head!=null){
                if(head.val == v1){
                    prev1= prev;
                    v1Ptr = head;
                }if(head.val == v2){
                    prev2 = prev;
                    v2Ptr = head;
                }
                head = head.next;
                prev= prev.next;
            }
            if(prev1!=null || prev2 != null){
                prev1.next = v2Ptr;
                prev2.next = v1Ptr;
                ListNode temp = v1Ptr.next;
                v1Ptr.next = v2Ptr.next;
                v2Ptr.next = temp;

            }
            return dummy.next;
        }

    @Test
     public void  test(){
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        swapNodes(head, 1, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
