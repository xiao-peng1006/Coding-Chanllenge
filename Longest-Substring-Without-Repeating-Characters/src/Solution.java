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
                // If the character does not exist in the set,
                // add it into the set and move to next portion by increase end by 1
                end++;
                set.add(s.charAt(end));
            } else {
                // If the end character already exists in the set,
                // keep removing character at start until getting the same character
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