class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 4, Output: " + solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println("Expected: 12, Output: " + solution.rob(new int[]{2, 7, 9, 3, 1}));
    }

}