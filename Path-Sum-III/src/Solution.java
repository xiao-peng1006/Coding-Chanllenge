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


    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    public int helper(TreeNode node, int currSum, int target, HashMap<Integer, Integer> map) {
        if (node == null)
            return 0;

        currSum += node.val;
        int res = map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        res += helper(node.left, currSum, target, map) + helper(node.right, currSum, target, map);
        map.put(currSum, map.get(currSum) - 1);
        return res;
    }
}