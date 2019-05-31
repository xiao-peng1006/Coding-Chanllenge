class Solution {

    /**
     * Leetcode 91. Decode Ways
     *
     * @param s
     * @return
     */

    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        char[] array = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            if (array[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1) {
                int num = (array[i - 2] - '0') * 10 + array[i - 1] - '0';
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 2, Output: " + solution.numDecodings("12"));
        System.out.println("Expected: 3, Output: " + solution.numDecodings("226"));
        System.out.println("Expected: 2, Output: " + solution.numDecodings("236"));
        System.out.println("Expected: 0, Output: " + solution.numDecodings("6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"));
    }
}