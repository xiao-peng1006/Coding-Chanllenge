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
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int ans;

    /**
     * Leetcode 687. Longest Univalue Path
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.ans = 0;
        helper(root);
        return this.ans;
    }

    public int helper(TreeNode node) {
        if (node == null)
            return 0;

        int l = helper(node.left);
        int r = helper(node.right);
        int pl = 0;
        int pr = 0;
        if (node.left != null && node.left.val == node.val) {
            pl = l + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            pr = r + 1;
        }
        this.ans = Math.max(this.ans, pl + pr);
        return Math.max(pl, pr);
    }
}