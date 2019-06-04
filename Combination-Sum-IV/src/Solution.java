class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] = dp[i] + dp[i - nums[j]];

            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 7, Output: " + solution.combinationSum4(new int[]{1, 2, 3}, 4));

        System.out.println("Expected: 0, Output: " + solution.combinationSum4(new int[]{1, 2, 3}, 0));

        System.out.println("Expected: 0, Output: " + solution.combinationSum4(new int[]{}, 0));

        System.out.println("Expected: 1132436852, Output: " + solution.combinationSum4(new int[]{1, 2, 3}, 35));

        System.out.println("Expected: 0, Output: " + solution.combinationSum4(new int[]{3, 33, 333}, 10000));
    }
}