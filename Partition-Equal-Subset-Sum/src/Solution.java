class Solution {
    public boolean canPartition(int[] nums) {

        int target = 0;
        for (int num : nums) {
            target += num;
        }

        if (target % 2 != 0)
            return false;

        target = target / 2;

        boolean[] memo = new boolean[target + 1];
        for (int i = 0; i <= target; i++) {
            memo[i] = (nums[0] == i);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                memo[j] =  memo[j] || memo[j - nums[i]];
            }
        }

        return memo[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Expected: false, Output: " + solution.canPartition(new int[]{1, 2, 5}));

        System.out.println("Expected: true, Output: " + solution.canPartition(new int[]{1, 5, 11, 5}));

        System.out.println("Expected: false, Output: " + solution.canPartition(new int[]{1, 2, 3, 5}));
    }
}