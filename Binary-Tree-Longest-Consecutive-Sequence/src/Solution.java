/**
 * Definition for a binary tree node.

 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return this.maxLength;
    }

    public void dfs(TreeNode node, TreeNode pre, int length) {
        if (pre == null) {
            return;
        }

        length = (pre != null && node.val == pre.val + 1) ? length + 1 : 1;
        this.maxLength = Math.max(this.maxLength, length);
        dfs(node.left, node, length);
        dfs(node.right, node, length);
    }
}