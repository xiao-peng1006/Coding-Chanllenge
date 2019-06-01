class Solution {
    int[] memo;

    public int rob(int[] nums) {
        this.memo = new int[nums.length + 1];
        return dp(nums, 0);
    }

    public int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        if (this.memo[start] != 0) {
            return this.memo[start];
        }

        int res = 0;
        for (int i = start; i < nums.length; i++) {
            res = Math.max(res, nums[i] + dp(nums, i + 2));
        }
        this.memo[start] = res;

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 4, Output: " + solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println("Expected: 12, Output: " + solution.rob(new int[]{2, 7, 9, 3, 1}));
    }
}