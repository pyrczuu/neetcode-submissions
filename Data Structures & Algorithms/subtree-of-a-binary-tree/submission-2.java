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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null || root == null) {
            return false;
        }

        TreeNode curr = root;
        Stack<TreeNode> matches = new Stack<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(curr);

        while (!nodes.isEmpty()) {
            if (curr.val == subRoot.val) {
                matches.push(curr);
            }
            if (curr.left != null) {
                nodes.push(curr.left);
            }
            if (curr.right != null) {
                nodes.push(curr.right);
            }
            curr = nodes.pop();
        }
        while (!matches.isEmpty()) {
            boolean res = compareTrees(subRoot, matches.pop());
            if (res) {
                return res;
            }
        }
        return false;
    }

    public boolean compareTrees(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return compareTrees(p.left, q.left) && compareTrees(p.right, q.right);
    }
}
