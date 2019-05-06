import java.util.HashSet;

class Solution {

    /**
     * Leetcode 409. Longest Palindrome
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (Character c:s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                res += 2;
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? res : res + 1 ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 7, Output: " + solution.longestPalindrome("abccccdd"));

        System.out.println("Expected: 2, Output: " + solution.longestPalindrome("bb"));
    }
}