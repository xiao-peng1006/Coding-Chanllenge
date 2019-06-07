class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] memo = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (memo[j] == 1 && nums[i] != nums[j]) {
                    memo[i] = nums[i] > nums[j] ? 2 : -2;
                }
                if (memo[j] > 0) {
                    if ((memo[j] % 2 != 0 && nums[i] > nums[j]) ||(memo[j] % 2 == 0 && nums[i] < nums[j]))
                        memo[i] = Math.max(memo[i], 1 + memo[j]);
                } else {
                    if ((memo[j] % 2 != 0 && nums[i] < nums[j]) ||(memo[j] % 2 == 0 && nums[i] > nums[j]))
                        memo[i] = -Math.max(memo[i], 1 - memo[j]);
                }
            }
            res = Math.max(res, Math.abs(memo[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 0, Output: " + solution.wiggleMaxLength(new int[]{}));

        System.out.println("Expected: 6, Output: " + solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));

        System.out.println("Expected: 7, Output: " + solution.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));

        System.out.println("Expected: 2, Output: " + solution.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));

        System.out.println("Expected: 3, Output: " + solution.wiggleMaxLength(new int[]{3, 3, 3, 2, 5}));
    }
}