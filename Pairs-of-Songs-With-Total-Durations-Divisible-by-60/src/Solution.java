class Solution {

    /**
     * Leetcode 1010. Pairs of Songs With Total Durations Divisible by 60
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0)
            return 0;
        int res = 0, len = time.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Expected: 3, Output: " + solution.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));

        System.out.println("Expected: 3, Output: " + solution.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}