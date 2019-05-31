class Solution {

    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                memo[i] = Math.min(memo[i], 1 + memo[i - j * j]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Expected: 3, Output: " + solution.numSquares(12));

        System.out.println("Expected: 2, Output: " + solution.numSquares(13));

        System.out.println("Expected: 2, Output: " + solution.numSquares(2));
    }
}