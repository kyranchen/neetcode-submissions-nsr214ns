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
    private int res;
    public int goodNodes(TreeNode root) {
        res = 0;
        if (root == null) return res;
        // root is always good
        dfs(root, Integer.MIN_VALUE);


        return res;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) return;

        if (node.val >= max) {
            res += 1;
            max = node.val;
        }

        dfs(node.left, max);
        dfs(node.right, max);
        return;
    }


}
