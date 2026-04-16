/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        TreeNode curr = root; 

        while (curr != null) {
            TreeNode next = null;
            TreeNode temp = curr.right;
            curr.right = curr.left;
            curr.left = temp;
            visited.put(curr, true);
            if (curr.left != null && !visited.getOrDefault(curr.left, false)) {
                stack.push(curr.left);
            }
            if (curr.right != null && !visited.getOrDefault(curr.right, false)) {
                next = curr.right;
            } else if (!stack.empty()) {
                next = stack.pop();
            }
            curr = next;
        }
        return root;
    }
}
