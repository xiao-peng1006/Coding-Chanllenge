import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    /**
     * Leetcode 47. Permutations II
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
    }

    public void helper(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> list) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1])
                continue;

            temp.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, temp, list);
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(new int[]{1, 1, 2});
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < res.size(); i++) {
            sb.append("[");
            for (int j = 0; j < res.get(i).size(); j++) {
                if (j == res.get(i).size() - 1)
                    sb.append(res.get(i).get(j));
                else
                    sb.append(res.get(i).get(j) + ",");
            }
            if (i == res.size()-1)
                sb.append("]");
            else
                sb.append("], ");
        }
        sb.append(" ]");
        System.out.println("Expected: [ [1,1,2], [1,2,1], [2,1,1] ], Output: " + sb.toString());
    }
}