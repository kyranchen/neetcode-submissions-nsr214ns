/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode trav1 = l1;
        ListNode trav2 = l2;
        ListNode dummy = new ListNode();
        ListNode res = dummy;

        int offset = 0;

        while (trav1 != null && trav2 != null) {
            int val = trav1.val + trav2.val;
            res.next = new ListNode((val % 10) + offset);
            offset = val >= 10 ? 1 : 0;

            res = res.next;
            trav1 = trav1.next;
            trav2 = trav2.next;
        }

        while (trav1 != null) {
            int val = trav1.val + offset;
            res.next = new ListNode((val % 10));
            offset = val >= 10 ? 1 : 0;

            res = res.next;
            trav1 = trav1.next;
        }

        while (trav2 != null) {
            int val = trav2.val + offset;
            res.next = new ListNode((val % 10));
            offset = val >= 10 ? 1 : 0;

            res = res.next;
            trav2 = trav2.next;
        }

        if (offset == 1) {
            res.next = new ListNode(1);
        }

        return dummy.next;
    }
}
