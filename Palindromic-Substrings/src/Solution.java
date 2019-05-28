import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * Leetcode 647. Palindromic Substrings
     * @param s
     * @return
     */
    int res;
    String s;
    public int countSubstrings(String s) {
        this.res = 0;
        this.s = s;
        for (int i = 0; i < s.length(); i++) {
            helper(i, i);

            helper(i, i + 1);
        }
        return this.res;

    }

    private void helper(int start, int end) {
        if (start < 0 || end >= this.s.length())
            return;
        String s = this.s.substring(start, end + 1);
        if (!isPalindrome(s)) {
            return;
        }
        this.res++;
        helper(start - 1, end + 1);
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++; r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.countSubstrings("abc"));

        System.out.println("Expected: 6, Output: " + solution.countSubstrings("aaa"));

        System.out.println("Expected: 0, Output: " + solution.countSubstrings(""));
    }
}