import java.util.ArrayList;
import java.util.List;

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

    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.ans = new ArrayList<>();
        getDistance(root, target, K);
        return this.ans;
    }

    public int getDistance(TreeNode node, TreeNode target, int K) {
        if (node == null) return -1;
        if (node == target) {
            getAns(target, K);
            return 0;
        }

        int l = getDistance(node.left, target, K);
        int r = getDistance(node.right, target, K);

        if (l >= 0) {
            if (l == K - 1)
                this.ans.add(node.val);
            getAns(node.right, K - l - 2);
            return l + 1;
        }

        if (r >= 0) {
            if (r == K - 1)
                this.ans.add(node.val);
            getAns(node.left, K - r - 2);
            return r + 1;
        }

        return -1;
    }

    public void getAns(TreeNode node, int depth) {
        if (node == null || depth < 0) return;
        if (depth == 0) this.ans.add(node.val);
        getAns(node.left, depth - 1);
        getAns(node.right, depth - 1);
    }
}