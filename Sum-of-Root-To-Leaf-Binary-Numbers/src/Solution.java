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

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int val) {
        if (node == null)
            return 0;
        val = val*2 + node.val;
        return (node.left == null && node.right == null) ? val : dfs(node.left, val) + dfs(node.right, val);
    }
}