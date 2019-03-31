import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Leetcode 17. Letter Combinations of a Phone Number
     *
     * @param digits
     * @return
     */

    String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() <= 0)
            return res;
        helper(digits, 0, "", res);
        return res;
    }

    private void helper(String digits, int index, String temp, List<String> list) {
        if (temp.length() == digits.length()) {
            list.add(temp);
            return;
        }

        String letters = dict[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++ ) {
            helper(digits, index+1, temp+letters.charAt(i), list);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String digits = "23";

    }
}