import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Leetcode 78. Subsets
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
        if (start <= nums.length) {
            res.add(temp);
            // No return,
        }

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, i+1, new ArrayList<Integer>(temp), res);
            temp.remove(temp.size()-1);
        }
    }
}