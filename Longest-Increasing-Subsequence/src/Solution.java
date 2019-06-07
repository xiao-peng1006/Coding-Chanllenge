class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
            }
            res = Math.max(res, memo[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 4, Output: " + solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println("Expected: 2, Output: " + solution.lengthOfLIS(new int[]{-2, -1}));
    }
}