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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;

        dfs(root);

        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);

        max = Math.max(max, node.val + leftSum + rightSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}
