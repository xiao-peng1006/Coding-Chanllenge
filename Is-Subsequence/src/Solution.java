import java.util.HashSet;

class Solution {

    /**
     * Leetcode 392. Is Subsequence
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (t.length() == 0 && s.length() == 0)
            return true;
        else if (t.length() == 0)
            return false;
        else if (s.length() == 0)
            return true;

        int index = 0;
        for (Character c:t.toCharArray()) {
            if (c == s.charAt(index)) {
                index++;
            }
            if (index >= s.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abc", t = "ahbgdc";
        System.out.println("Expected: true, Output: " + sol.isSubsequence(s, t));

        s = "axc"; t = "ahbgdc";
        System.out.println("Expected: false, Output: " + sol.isSubsequence(s, t));

        s = "acb"; t = "ahbgdc";
        System.out.println("Expected: false, Output: " + sol.isSubsequence(s, t));

        s = ""; t = "ahbgdc";
        System.out.println("Expected: true, Output: " + sol.isSubsequence(s, t));

        s = "acb"; t = "";
        System.out.println("Expected: false, Output: " + sol.isSubsequence(s, t));

        s = ""; t = "";
        System.out.println("Expected: true, Output: " + sol.isSubsequence(s, t));
    }
}