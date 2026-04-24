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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> nodeList = treeToList(root);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            int lastIdx = nodeList.get(i).size() - 1;
            ans.add(nodeList.get(i).get(lastIdx).val);
        }
        return ans;
    }
    private ArrayList<ArrayList<TreeNode>> treeToList(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayList<TreeNode> level = new ArrayList<>();
        level.add(root);

        while (level.size() > 0) {
            res.add(level);
            ArrayList<TreeNode> nextLevel = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                TreeNode curr = level.get(i);
                if (curr.left != null) nextLevel.add(curr.left);
                if (curr.right != null) nextLevel.add(curr.right);
            }
            level = nextLevel;
        }
        return res;
    }
}