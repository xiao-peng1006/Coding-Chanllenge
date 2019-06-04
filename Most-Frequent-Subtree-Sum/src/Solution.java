import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    HashMap<Integer, Integer> map;
    int maxCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        this.map = new HashMap<>();
        maxCount = 0;
        dfs(root);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry entry:map.entrySet()) {
            if (entry.getValue().equals(this.maxCount)) {
                res.add((Integer) entry.getKey());
            }
        }

        int[] ans = new int[res.size()];
        int count = 0;
        for (Object i : res.toArray()) {
            ans[count++] = (Integer) i;
        }
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = 0;
        sum += node.val + dfs(node.left) + dfs(node.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        this.maxCount = Math.max(this.maxCount, map.get(sum));
        return sum;
    }

}