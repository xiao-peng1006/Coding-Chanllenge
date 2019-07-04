import java.util.*;

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int num = 0;
        boolean r = false;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            num = queue.size();
            List<Integer> levelres = new ArrayList<Integer>();

            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                levelres.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (r) {
                Collections.reverse(levelres);
            }
            r = !r;
            res.add(levelres);
        }
        return res;
    }
}