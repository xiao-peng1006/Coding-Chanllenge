class Solution {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 0;
        this.memo = new int[target + 1];
        this.memo[0] = 0;
        return helper(nums, target);
    }

    public int helper(int[] nums, int target) {
        if (target < 0)
            return 0;

        if (target == 0) {
            return 1;
        }

        if (this.memo[target] != 0) {
            return this.memo[target];
        }

        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                this.memo[target] = this.memo[target] + helper(nums, target - nums[i]);
        }

        return this.memo[target];
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