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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        if (head.next == null) return head;

        ListNode prev = null;
        ListNode trav = head;

        //    1 -> 2 -> 3 -> 4 -> null
        //                   p    t
        // 1. point trav.next to prev

        while (trav != null) {
            ListNode next = trav.next;
            trav.next = prev;
            prev = trav;
            trav = next;
        }

        return prev;
    }
}
