import java.util.Arrays;

class Solution {

    /**
     * Leetcode 435. Non-overlapping Intervals
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals == null)
            return 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] memo = new int[intervals.length];
        memo[0] = 1;
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1])
                    memo[i] = Math.max(memo[i], memo[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }

        return intervals.length - res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Expected: 1, Output: " + sol.eraseOverlapIntervals(intervals));

        intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Expected: 2, Output: " + sol.eraseOverlapIntervals(intervals));

        intervals = new int[][]{{1, 2}, {2, 3}};
        System.out.println("Expected: 0, Output: " + sol.eraseOverlapIntervals(intervals));

        intervals = new int[][]{{-100, -96}, {-99, -87}, {-96, -90}, {-96, -87}};
        System.out.println("Expected: 2, Output: " + sol.eraseOverlapIntervals(intervals));

    }
}