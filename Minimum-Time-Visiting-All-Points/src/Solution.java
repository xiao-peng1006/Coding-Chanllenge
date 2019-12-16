class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 0 || points.length == 1) return 0;
        int res = 0;
        int[] prev, next;
        prev = points[0];
        for (int i = 1; i < points.length; i++) {
            next = points[i];
            res += Math.max(Math.abs(next[0] - prev[0]), Math.abs(next[1] - prev[1]));
            prev = next;
        }
        return res;
    }
}