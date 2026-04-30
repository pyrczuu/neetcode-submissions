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

public class Codec {
    int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String serialized = "";
        if (root == null) return "NULL,";
        serialized += root.val + ",";
        serialized += serialize(root.left);
        serialized += serialize(root.right);
        return serialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("NULL") || data.isEmpty()) return null;
        String[] split = data.split(",");
        i = 0;
        return dfs(split);
    }
    private TreeNode dfs(String[] data) {
        if (i >= data.length || data.length < 1 || data[i].equals("NULL")) {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data[i]));
        i++;
        node.left = dfs(data);
        node.right = dfs(data);
        return node;
    }
}
