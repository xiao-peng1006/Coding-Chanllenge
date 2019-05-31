class Solution {
    int[] memo;

    public int numSquares(int n) {
        this.memo = new int[n + 1];
        return dp(n);
    }

    private int dp(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (this.memo[n] != 0) {
            return this.memo[n];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, 1 + dp(n - (i * i)));
        }
        this.memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Expected: 3, Output: " + solution.numSquares(12));

        System.out.println("Expected: 2, Output: " + solution.numSquares(13));

        System.out.println("Expected: 2, Output: " + solution.numSquares(2));
    }
}