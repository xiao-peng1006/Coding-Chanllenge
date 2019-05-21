import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {

    /**
     * Leetcode 532. K-diff Pairs in an Array
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)
            return 0;
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (set.contains(num)) {
                    res++;
                    while (i + 1 < nums.length && nums[i + 1] == num) {
                        i++;
                    }
                }
                set.add(num);

            }
        } else {
            for (int num : nums) {
                if (set.contains(num)) continue;
                if (set.contains(num - k)) {
                    res++;
                }
                if (set.contains(num + k)) {
                    res++;
                }
                set.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Expected: 2, Output: " + solution.findPairs(new int[]{3, 1, 4, 1, 5}, 2));

        System.out.println("Expected: 4, Output: " + solution.findPairs(new int[]{1, 2, 3, 4, 5}, 1));

        System.out.println("Expected: 1, Output: " + solution.findPairs(new int[]{1, 3, 1, 1, 1, 5, 4}, 0));

        System.out.println("Expected: 1, Output: " + solution.findPairs(new int[]{1, 1, 1, 1}, 0));

        System.out.println("Expected: 0, Output: " + solution.findPairs(new int[]{1, 2, 3, 4, 5}, -1));
    }
}