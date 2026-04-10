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
        ListNode head = new ListNode();
        ListNode curr = head;
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        int carry = 0;

        while (curL1 != null || curL2 != null || carry > 0) {
            int num1 = curL1 != null ? curL1.val : 0;
            int num2 = curL2 != null ? curL2.val : 0;
            int sum = num1 + num2 + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum >= 10 ? 1 : 0;
            curr = curr.next;
            if (curL1 != null) { curL1 = curL1.next; }
            if (curL2 != null) { curL2 = curL2.next; }
        }
        return head.next;
    }
}
