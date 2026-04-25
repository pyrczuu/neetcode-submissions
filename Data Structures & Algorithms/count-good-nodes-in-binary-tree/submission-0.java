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
    private int count = 0;
    public int goodNodes(TreeNode root) {
        count = 0;
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
    private void dfs(TreeNode root, int max_val) {
        if (root == null) return;
        if (root.val >= max_val) {
            max_val = root.val;
            count++;
        } 
        dfs(root.left, max_val);
        dfs(root.right, max_val);
    }
}
