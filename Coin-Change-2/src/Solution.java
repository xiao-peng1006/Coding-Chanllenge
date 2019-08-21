import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
        System.out.println(solution.change(3, new int[]{2}));
        System.out.println(solution.change(10, new int[]{10}));
    }
}