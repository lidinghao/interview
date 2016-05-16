package LinkedList;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by mandy on 2016/5/12.
 */
public class MergeKSortedLists {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0] ;
        ListNode[] newLists = new ListNode[(lists.length + 1) / 2];
        for (int i = 0; i < lists.length / 2; i++) {
            ListNode node = mergeTwoLists(lists[2*i], lists[2*i + 1]);
            newLists[i] = node;
        }
        if (lists.length %2 != 0) newLists[(lists.length + 1) / 2 - 1] = lists[lists.length - 1];
        return mergeKLists(newLists);
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
    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return  -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;
            if (tail.next != null)
            minHeap.add(tail.next);
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        ListNode l3 = new ListNode(4);
        l3.next = new ListNode(6);
        l3.next.next = new ListNode(7);
        ListNode[] lists = {l1, l2, l3};
        ListNode list = mergeKListsV2(lists);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }

    }
}
