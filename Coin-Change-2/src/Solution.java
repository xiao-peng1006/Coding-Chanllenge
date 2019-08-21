import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    int res;
    int[] memo;
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins.length == 0) return 0;
        this.res = 0;
        this.memo = new int[amount];
        Arrays.sort(coins);
        helper(amount, coins, coins.length - 1);
        return res;
    }

    public void helper(int amount, int[] coins, int start) {
        if (amount == 0) {
            this.res++;
            return;
        }

        if (amount > 0) {
            for (int i = start; i >= 0; i--) {
                amount -= coins[i];
                helper(amount, coins, i);
                amount += coins[i];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
        System.out.println(solution.change(3, new int[]{2}));
        System.out.println(solution.change(10, new int[]{10}));
    }
}