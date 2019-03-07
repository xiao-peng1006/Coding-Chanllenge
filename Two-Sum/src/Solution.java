import java.util.*;

/**
 *  LeetCode - 1
 *
 * Thoughts: Initialize  a hashmap to store data set, if the difference (target - nums[i]) does not in the hashmap,
 * add nums[i] and i into hashmap. If the difference is found, return the index for difference and current i.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};
            else
                map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] testNums; int testTarget; StringBuilder sb;
        int[] ans;

        testNums = new int[] {2, 7, 11, 15};
        testTarget = 9;
        ans = sol.twoSum(testNums, testTarget);

        sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < ans.length; i++) {
            sb.append(String.valueOf(ans[i]));
            if (i != ans.length - 1)
                sb.append(", ");
        }
        sb.append(']');
        System.out.println("Expected: [0, 1], Output: " + sb.toString());

        testNums = new int[] {2, 7, 11, 15};
        testTarget = 13;
        ans = sol.twoSum(testNums, testTarget);

        sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < ans.length; i++) {
            sb.append(String.valueOf(ans[i]));
            if (i != ans.length - 1)
                sb.append(", ");
        }
        sb.append(']');
        System.out.println("Expected: [0, 2], Output: " + sb.toString());

    }
}
