import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 46 Permutations
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0 || nums == null) return res;
        helper(nums, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length)
            res.add(new ArrayList<Integer>(list));

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(nums, list, res);
            list.remove(list.size()-1);
        }
    }
}