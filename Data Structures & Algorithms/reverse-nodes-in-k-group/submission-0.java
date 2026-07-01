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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 1) return head;

        ListNode trav = head;
        int n = 0;
        while (trav != null) {
            n += 1;
            trav = trav.next;
        }

        int times = n / k;
        ListNode prevTail = null;
        ListNode newFirstHead = null;

        trav = head;
        while (times > 0) {
            ListNode groupEnd = trav;
            for (int i = 0; i < k; i++) {
                groupEnd = groupEnd.next;
            }

            ListNode newHead = reverseLinkedList(trav, k, groupEnd);

            if (prevTail == null) {
                newFirstHead = newHead;
            } else {
                prevTail.next = newHead;
            }

            // Trav is the end of the group
            prevTail = trav;
            trav = groupEnd;
            
            times -= 1;
        }

        return newFirstHead;
    }

    private ListNode reverseLinkedList(ListNode node, int k, ListNode newHead) {
        // Reverse k nodes and return the reference of the last node
        // The last node will be the first node we start with
        // So we can keep the reference
        ListNode trav = node;
        ListNode prev = newHead;

        while (k > 0) {
            ListNode next = trav.next;
            trav.next = prev;
            prev = trav;
            trav = next;
            k -= 1;
        }

        return prev;
    }
}