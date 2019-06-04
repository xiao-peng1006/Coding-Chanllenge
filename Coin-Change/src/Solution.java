class Solution {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.coinChange(new int[]{1, 2, 5}, 11));

        System.out.println("Expected: -1, Output: " + solution.coinChange(new int[]{2}, 3));
    }
}