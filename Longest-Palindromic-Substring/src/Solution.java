class Solution {

    /**
     * Leetcode 5. Longest Palindromic Substring
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null)
            return "";
        String longestPalindrome = s.substring(0,1);
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res = helper(s, i, i);
            if (res.length() > longestPalindrome.length())
                longestPalindrome = res;
        }

        for (int i = 0; i < s.length()-1; i++) {
            res = helper(s, i, i+1);
            if (res.length() > longestPalindrome.length())
                longestPalindrome = res;
        }

        return longestPalindrome;
    }

    public String helper(String s, int start, int end) {
        if (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            return helper(s, start-1, end+1);
        }
        return s.substring(start+1, end);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Expected: \"bab\", Output: \"" + sol.longestPalindrome("babad") + "\"");

        System.out.println("Expected: \"bb\", Output: \"" + sol.longestPalindrome("cbbd") + "\"");

        System.out.println("Expected: \"\", Output: \"" + sol.longestPalindrome("") + "\"");

        System.out.println("Expected: \"a\", Output: \"" + sol.longestPalindrome("a") + "\"");
    }
}