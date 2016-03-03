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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);
        ListNode result = sumList;;
        int carry = 0;
        while (l1!= null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry =  sum / 10;
            result.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        ListNode remainList;
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

            //result = new
        }
        return null;
    }

}
