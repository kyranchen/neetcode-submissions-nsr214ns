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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode trav1 = head;

        for (int i = 0; i < n; i++) {
            trav1 = trav1.next;
        }

        ListNode trav2 = head;
        ListNode prev = null;

        while (trav1 != null) {
            prev = trav2;
            trav1 = trav1.next;
            trav2 = trav2.next;
        }

        if (prev != null) {
            prev.next = trav2.next;
        } else return trav2.next;

        return head;
    }
}
