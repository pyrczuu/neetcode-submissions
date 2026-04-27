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
    private ArrayList<Integer> vals;
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> vals = new ArrayList<>();
        dfs(root, vals);
        Collections.sort(vals);
        return vals.get(k-1);
    }
    private void dfs(TreeNode root, ArrayList<Integer> vals) {
        if (root == null) return;
        vals.add(root.val);
        dfs(root.left, vals);
        dfs(root.right, vals);
    }
}
