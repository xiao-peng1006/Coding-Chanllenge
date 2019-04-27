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
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j+1);
                if (isPalindrome(str))
                    longestPalindrome = longestPalindrome.length() > str.length() ? longestPalindrome : str;
            }
        }
        return longestPalindrome;
    }

    public boolean isPalindrome(String str) {
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Expected: \"bab\", Output: \"" + sol.longestPalindrome("babad") + "\"");

        System.out.println("Expected: \"bb\", Output: \"" + sol.longestPalindrome("cbbd") + "\"");

        System.out.println("Expected: \"\", Output: \"" + sol.longestPalindrome("") + "\"");

        System.out.println("Expected: \"a\", Output: \"" + sol.longestPalindrome("a") + "\"");
    }
}