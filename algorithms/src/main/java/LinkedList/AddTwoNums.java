package LinkedList;

/**
 * Created by mandy on 2016/3/3.
 */
public class AddTwoNums {

//     * Definition for singly-linked list.
      public static  class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);
        ListNode result = sumList;;
        int carry = 0;
        //compute the sum
        while (l1!= null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry =  sum / 10;
            result.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }

        //compute the remain of the longer list
        ListNode remainList = null;
        if (l1 != null) {
            remainList = l1;
        } else {
            remainList = l2;
        }
        while (remainList != null) {
            int sum = carry + remainList.val;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            remainList = remainList.next;
            result = result.next;
        }

        //compute the carry
        if (carry == 1) {
            result.next = new ListNode(carry);
        }

        return sumList.next;
    }

    public static ListNode addTwoNums(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        // two choices for control flow
        // 1. for
/*        for (ListNode pA = l1, pB = l2;
             pA != null || pB != null;
             pA = pA == null ? null : pA.next,
             pB = pB == null ? null : pB.next,
             prev = prev.next) {

            int valA = pA == null ? 0 : pA.val;
            int valB = pB == null ? 0 : pB.val;

            int sum = (carry + valA + valB) % 10;
            carry = (valA + valB) / 10;

            prev.next = new ListNode(sum);

        }*/
        //2. while
        ListNode pA = l1, pB = l2;
        while (pA != null || pB != null) {
            int valA = pA == null ? 0 : pA.val;
            int valB = pB == null ? 0 : pB.val;

            int sum = (carry + valA + valB) % 10;
            carry = (valA + valB) / 10;
            prev.next = new ListNode(sum);
            prev = prev.next;

            pA = pA == null ? null : pA.next;
            pB = pB == null ? null : pB.next;
        }

        if (carry == 1) {
            prev.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
