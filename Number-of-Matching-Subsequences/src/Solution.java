import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        for (String word : words) {
            if (isSubsequence(S, word)) {
                res++;
            }
        }
        return res;
    }

    public boolean isSubsequence(String S, String subString) {
        int index = 0, subIndex = 0;
        while (index < S.length() && subIndex < subString.length()) {
            if (S.charAt(index) == subString.charAt(subIndex)) {
                index++;
                subIndex++;
            } else {
                index++;
            }
        }
        return subIndex == subString.length() ? true : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));

    }
}