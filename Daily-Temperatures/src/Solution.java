class Solution {

    /**
     * Leetcode 739. Daily Temperatures
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        for (int i = 0; i < T.length; i++) {
            for (int j = i; j < T.length; j++) {
                if (T[j] > T[i]) {
                    T[i] = j - i;
                    break;
                }
                if (j == T.length - 1 && T[j] <= T[i]) {
                    T[i] = 0;
                }
            }
        }
        return T;
    }
}