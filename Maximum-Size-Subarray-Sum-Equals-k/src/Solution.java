import java.util.HashMap;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLength = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 4, Output: " + solution.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));

        System.out.println("Expected: 2, Output: " + solution.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));

        System.out.println("Expected: 2, Output: " + solution.maxSubArrayLen(new int[]{1, 0, -1}, -1));
    }
}