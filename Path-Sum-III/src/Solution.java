import java.util.*;

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
    public class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int sum, count = 0;
    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        dfs(root, 0, 0, new ArrayList<Integer>());
        return count;
    }

    public void dfs(TreeNode node, int partialSum, int index, List<Integer> list) {
        if (node == null)
            return;

        partialSum += node.val;

        if (partialSum == sum)
            count++;
        int temp = partialSum;
        for (Object i: list.toArray()) {
            temp -= (Integer) i;
            if (temp == sum)
                count++;
        }

        list.add(node.val);

        dfs(node.left, partialSum, index + 1, new ArrayList<Integer>(list));
        dfs(node.right, partialSum, index + 1, new ArrayList<Integer>(list));
    }
}