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
    private int preOrderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Since node values are unique, we can use a hashmap to keep track of the node to the indices
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, map, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, HashMap<Integer, Integer> map, int left, int right) {
        if (left > right) return null;

        int val = preorder[preOrderIndex];
        preOrderIndex++;
        TreeNode node = new TreeNode(val);
        int mid = map.get(val);
        node.left = dfs(preorder, map, left, mid - 1);
        node.right = dfs(preorder, map, mid + 1, right);

        return node;
    }
}
