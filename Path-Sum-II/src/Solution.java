import java.util.ArrayList;
import java.util.List;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    public void dfs(TreeNode node, int sum, List<Integer> list, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        sum -= node.val;

        if (node.left == null && node.right == null) {
            if (sum == 0)
                res.add(new ArrayList<>(list));
        } else {
            if (node.left != null) {
                dfs(node.left, sum, list, res);
            }
            if (node.right != null) {
                dfs(node.right, sum, list, res);
            }
        }
        list.remove(list.size() - 1);
    }
}