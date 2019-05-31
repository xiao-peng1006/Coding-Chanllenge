class Solution {

    /**
     * Leetcode 343. Integer Break
     */

    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = Math.max(memo[i], Math.max(j * (i - j), j * memo[i - j]));
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 1, Output: " + solution.integerBreak(2));

        System.out.println("Expected: 36, Output: " + solution.integerBreak(10));
    }
}