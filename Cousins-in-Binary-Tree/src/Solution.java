import java.util.HashMap;
import java.util.Map;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, int[]> map;
    public boolean isCousins(TreeNode root, int x, int y) {
        map = new HashMap<>();
        helper(root, 0, 0);
        int[] xData = map.get(x);
        int[] yData = map.get(y);
        return xData[0] == yData[0] && xData[1] != yData[1];
    }

    public void helper(TreeNode node, int depth, int parent) {
        if (node == null) {
            return;
        }

        map.put(node.val, new int[]{depth, parent});

        helper(node.left, depth + 1, node.val);
        helper(node.right, depth + 1, node.val);
    }
}