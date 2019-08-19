class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int res;
    public int rangeSumBST(TreeNode root, int L, int R) {
        res = 0;
        helper(root, L, R);
        return res;
    }

    public void helper(TreeNode node, int L, int R) {
        if (node != null) {
            if (node.val <= R && node.val >= L) {
                this.res += node.val;
                helper(node.left, L, R);
                helper(node.right, L, R);
            }

            if (node.val > R) {
                helper(node.left, L, R);
            }

            if (node.val < L) {
                helper(node.right, L, R);
            }
        }
    }
}