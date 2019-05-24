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

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public int dfs(TreeNode node, List<List<Integer>> res) {
        if (node == null)
            return -1;

        int depth = 1 + Math.max(dfs(node.left, res), dfs(node.right, res));

        if (depth >= res.size())
            res.add(depth, new ArrayList<>());

        res.get(depth).add(node.val);

        return depth;
    }
}