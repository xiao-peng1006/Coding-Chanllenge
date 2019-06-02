class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int length = prices.length;
        int[] hold = new int[length];
        int[] sell = new int[length];
        int[] cooldown = new int[length];
        hold[0] = -prices[0];
        sell[0] = 0;
        cooldown[0] = 0;
        for (int i = 1; i < length; i++) {
            cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
            hold[i] = Math.max(hold[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = hold[i - 1] + prices[i];
        }
        return Math.max(sell[length - 1], cooldown[length - 1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}