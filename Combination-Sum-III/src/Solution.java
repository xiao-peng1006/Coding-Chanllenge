import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    /**
     * Leetcode 216. Combination Sum III
     * @param k
     * @param n
     * @return
     */
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0) return res;
        helper(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private void helper(int k, int n, int start, List<Integer> temp, List<List<Integer>> list) {
        if (temp.size() == k && sum == n) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= 9; i++) {
            temp.add(i);
            sum += i;
            helper(k, n, i+1, temp, list);
            temp.remove(temp.size()-1);
            sum -= i;
        }
    }
}