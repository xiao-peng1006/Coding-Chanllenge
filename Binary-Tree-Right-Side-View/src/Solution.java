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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    public void dfs(TreeNode node, int depth, List<Integer> list) {
        if (node == null)
            return;

        if (list.size() == depth) {
            list.add(node.val);
        }
        dfs(node.right, depth + 1, list);
        dfs(node.left, depth + 1, list);
    }
}