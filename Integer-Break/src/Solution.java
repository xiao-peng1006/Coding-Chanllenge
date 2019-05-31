class Solution {

    /**
     * Leetcode 343. Integer Break
     * @param n
     * @return
     */
    int[] memo;

    public int integerBreak(int n) {
        this.memo = new int[n + 1];
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1)
            return 1;

        if (memo[n] != 0) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * breakInteger(n - i)));
        }
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 1, Output: " + solution.integerBreak(2));

        System.out.println("Expected: 36, Output: " + solution.integerBreak(10));
    }
}