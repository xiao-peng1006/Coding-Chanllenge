class Solution {
    int[][] memo;

    public boolean canPartition(int[] nums) {

        int target = 0;
        for (int num : nums) {
            target += num;
        }

        if (target % 2 != 0)
            return false;

        target = target / 2;
        this.memo = new int[nums.length][target + 1];
        return dp(nums, target, 0);
    }

    public boolean dp(int[] nums, int target, int index) {
        if (target < 0 || index >= nums.length)
            return false;

        if (target == 0)
            return true;

        if (this.memo[index][target] != 0) {
            return this.memo[index][target] == 1;
        }

        this.memo[index][target] = dp(nums, target, index + 1) || dp(nums, target - nums[index], index + 1) ? 1 : -1;
        return this.memo[index][target] == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Expected: false, Output: " + solution.canPartition(new int[]{1, 2, 5}));

        System.out.println("Expected: true, Output: " + solution.canPartition(new int[]{1, 5, 11, 5}));

        System.out.println("Expected: false, Output: " + solution.canPartition(new int[]{1, 2, 3, 5}));
    }
}