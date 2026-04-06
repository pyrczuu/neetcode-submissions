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
        HashMap<ListNode, Boolean> nodes = new HashMap<>();
        ListNode cur = head;
        boolean res = false;

        while (cur != null) {
            boolean visited = nodes.getOrDefault(cur.next, false);
            if (visited) {
                res = true;
                return res;
            }
            nodes.put(cur.next, true);
            cur = cur.next;
        }
        return res;
    }
}
