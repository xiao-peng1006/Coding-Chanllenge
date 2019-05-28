import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * Leetcode 983. Minimum Cost For Tickets
     * @param days
     * @param costs
     * @return
     */
    int[] cost;
    Integer[] memo;
    Set<Integer> set;
    public int mincostTickets(int[] days, int[] costs) {
        this.cost = costs;
        memo = new Integer[366];
        set = new HashSet<>();
        for (int day:days) set.add(day);

        return dp(1);
    }

    public int dp(int i) {
        if (i > 365)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans;
        if (set.contains(i)) {
            ans = Math.min(dp(i + 1) + cost[0], dp(i + 7) + cost[1]);
            ans = Math.min(ans, dp(i + 30) + cost[2]);
        } else {
            ans = dp(i + 1);
        }

        memo[i] = ans;
        return ans;
    }
}