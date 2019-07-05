import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void helper(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(list);
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                continue;
            }

            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, new ArrayList<>(list), res);
            list.remove(list.size() - 1);
        }
    }
}