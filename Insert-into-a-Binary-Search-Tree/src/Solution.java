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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        helper(root, val);
        return root;
    }

    public void helper(TreeNode node, int val) {
        if (val < node.val && node.left == null) {
            node.left = new TreeNode(val);
        } else if (val > node.val && node.right == null) {
            node.right = new TreeNode(val);
        }

        if (val < node.val)
            helper(node.left, val);
        else if (val > node.val)
            helper(node.right, val);
        else
            return;
    }
}