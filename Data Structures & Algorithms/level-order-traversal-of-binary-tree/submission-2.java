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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> lvl = new ArrayList<>();
        lvl.add(root);

        while (lvl.size() > 0) {
            List<TreeNode> nxtLvl = new ArrayList<>();
            List<Integer> curLvl = new ArrayList<>();
            for (int i = 0; i < lvl.size(); i++) {
                TreeNode curr = lvl.get(i);
                if (curr == null) continue;
                if (curr.left != null) nxtLvl.add(curr.left);
                if (curr.right != null) nxtLvl.add(curr.right);
                curLvl.add(curr.val);
            }
            if (curLvl.size() > 0) res.add(curLvl);
            lvl = nxtLvl;
        }
        return res;
    }
}
