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
    public boolean isValidBST(TreeNode root) {        
        return bfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean bfs(TreeNode root, int low, int high) {
        if (root == null) return true;
        if (root.val >= high || root.val <= low) return false;

        return bfs(root.left, low, root.val) && bfs(root.right, root.val, high);
    }
}
