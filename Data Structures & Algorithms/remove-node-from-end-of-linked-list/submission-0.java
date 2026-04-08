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
        // list approach 
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }
        int len = nodes.size();
        if (n > len) {
            return head;
        }
        int idx = len - n;
        ListNode prev = idx > 0 ? nodes.get(idx-1) : null;
        ListNode nxt = idx < len - 1 ? nodes.get(idx+1) : null;
        if (prev != null) {
            prev.next = nxt;
        } else {
            head = head.next;
        }

        return head;
    }
}
