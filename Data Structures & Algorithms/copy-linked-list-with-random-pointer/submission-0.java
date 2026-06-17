/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node trav = head;
        while (trav != null) {
            Node copy = new Node(trav.val);
            map.put(trav, copy);
            trav = trav.next;
        }

        Node res = map.get(head);
        Node trav2 = res;
        trav = head;
        
        while (trav != null) {
            trav2.next = map.get(trav.next);
            trav2.random = map.get(trav.random);
            trav = trav.next;
            trav2 = trav2.next;
        }

        return res;
    }
}
