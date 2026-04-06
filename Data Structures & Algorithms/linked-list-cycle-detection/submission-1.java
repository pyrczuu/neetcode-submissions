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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        ListNode cur = head;
        boolean res = false;

        while (cur != null) {
            if (nodes.contains(cur.next)) {
                res = true;
                return res;
            }
            nodes.add(cur.next);
            cur = cur.next;
        }
        return res;
    }
}
