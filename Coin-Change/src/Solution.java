class Solution {

    int[] memo;
    int amount;
    public int coinChange(int[] coins, int amount) {
        this.memo = new int[amount + 1];
        this.memo[0] = 0;
        for (int i = 1; i < this.memo.length; i++) {
            this.memo[i] = Integer.MAX_VALUE;
        }
        this.amount = amount;
        return dp(coins, amount);
    }

    public int dp(int[] coins, int target) {
        if (target < 0) {
            return -1;
        }

        if (this.memo[target] != Integer.MAX_VALUE)
            return this.memo[target];

        for (int i = 0; i < coins.length; i++) {
            int temp = dp(coins, target - coins[i]);
            if (temp >= 0) {
                this.memo[target] = Math.min(this.memo[target], temp + 1);
            }
        }

        return this.memo[target] = (this.memo[target] == Integer.MAX_VALUE) ? -1 : this.memo[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.coinChange(new int[]{1, 2, 5}, 11));

        System.out.println("Expected: -1, Output: " + solution.coinChange(new int[]{2}, 3));
    }
}