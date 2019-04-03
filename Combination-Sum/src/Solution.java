import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Leetcode 39. Combination Sum
     * @param candidates
     * @param target
     * @return
     */
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> list) {
        if (sum == target) {
            list.add(new ArrayList<>(temp));
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum > target) break;
            temp.add(candidates[i]);
            sum += candidates[i];
            helper(candidates, target, i, temp, list);
            temp.remove(temp.size()-1);
            sum -= candidates[i];
        }
    }
}