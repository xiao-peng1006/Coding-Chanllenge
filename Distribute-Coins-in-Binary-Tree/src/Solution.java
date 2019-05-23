/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int res;
    public int distributeCoins(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        res += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}