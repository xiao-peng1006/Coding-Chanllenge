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

    /**
     * Leetcode
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return helper(root, sum);
    }

    public boolean helper(TreeNode node, int sum) {
        if (node == null)
            return false;

        sum -= node.val;

        if (sum == 0 && node.left == null && node.right == null) {
            return true;
        }

        return helper(node.left, sum) || helper(node.right, sum);
    }
}