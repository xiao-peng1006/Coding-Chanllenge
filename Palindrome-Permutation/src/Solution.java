import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    /**
     * Leetcode 266. Palindrome Permutation
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (Character c:s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character key:map.keySet()) {
            count += map.get(key)%2;
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Expected: false, Output: " + solution.canPermutePalindrome("code"));

        System.out.println("Expected: true, Output: " + solution.canPermutePalindrome("aab"));

        System.out.println("Expected: true, Output: " + solution.canPermutePalindrome("carerac"));
    }
}