class Solution {

    /**
     * Leetcode 14. Longest Common Prefix
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ans = "";
        ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.length() < ans.length()) {
                ans = ans.substring(0, str.length());
            }
            for (int j = 0; j < str.length(); j++) {
                if (j >= ans.length() || ans.charAt(j) != str.charAt(j)) {
                    ans = ans.substring(0, j);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println("Expected: \"fl\", Output: \"" + solution.longestCommonPrefix(strs) + "\"");

        strs = new String[]{"dog", "racecar", "car"};
        System.out.println("Expected: \"\", Output: \"" + solution.longestCommonPrefix(strs) + "\"");

        strs = new String[]{"aa", "a"};
        System.out.println("Expected: \"a\", Output: \"" + solution.longestCommonPrefix(strs) + "\"");
    }
}