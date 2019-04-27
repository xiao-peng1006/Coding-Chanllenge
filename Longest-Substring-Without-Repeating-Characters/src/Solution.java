import java.util.HashMap;
import java.util.HashSet;

class Solution {

    /**
     * Leetcode 3. Longest Substring Without Repeating Characters
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s.length() == 0 || s == null)
            return res;

        HashSet<Character> set = new HashSet<>();
        int start = 0, end = -1;
        while (start < s.length() && end+1 < s.length()) {
            if (!set.contains(s.charAt(end+1))){
                end++;
                set.add(s.charAt(end));
            } else {
                set.remove(s.charAt(start));
                start++;
            }
            res = Math.max(res, end-start+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Expected: 3, Output: " + sol.lengthOfLongestSubstring("abcabcbb"));

        System.out.println("Expected: 1, Output: " + sol.lengthOfLongestSubstring("bbbbb"));

        System.out.println("Expected: 3, Output: " + sol.lengthOfLongestSubstring("pwwkew"));

        System.out.println("Expected: 2, Output: " + sol.lengthOfLongestSubstring("abba"));

    }
}