import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  res = new ArrayList<>();
        bfs(root, 0, res);
        return res;
    }

    public void bfs(TreeNode node, int depth, List<List<Integer>> list) {
        if (node == null) {
            return;
        }

        if (depth >= list.size()) {
            list.add(new ArrayList<Integer>());
        }

        list.get(depth).add(node.val);

        bfs(node.left, depth + 1, list);
        bfs(node.right, depth + 1, list);
    }
}