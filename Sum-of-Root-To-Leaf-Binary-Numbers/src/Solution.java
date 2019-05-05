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

    /**
     * Leetcode 1022. Sum of Root To Leaf Binary Numbers
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int res;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode node, String temp) {
        if (node.left == null && node.right == null) {
            res += Integer.parseInt(temp+node.val, 2);
            return;
        }

        if (node.left != null)
            dfs(node.left, temp+node.val);

        if (node.right != null)
            dfs(node.right, temp+node.val);
    }
}