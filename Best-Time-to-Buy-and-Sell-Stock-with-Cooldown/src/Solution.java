class Solution {
    int[] memo;

    public int maxProfit(int[] prices) {
        this.memo = new int[prices.length + 1];
        return dp(prices, 0);
    }

    public int dp(int[] prices, int start) {
        if (prices.length == 0 || prices.length == 1 || start >= prices.length) {
            return 0;
        }

        if (prices.length == 2) {
            return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        }

        if (this.memo[start] != 0) {
            return this.memo[start];
        }

        int res = 0;
        for (int i = start; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i])
                    continue;
                res = Math.max(res, prices[j] - prices[i] + dp(prices, j + 2));
            }
        }
        this.memo[start] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}