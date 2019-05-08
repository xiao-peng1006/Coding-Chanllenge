import java.util.Arrays;
import java.util.HashSet;

class Solution {

    /**
     * Leetcode Longest Word in Dictionary
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word: words) {
            set.add(word);
        }

        String res = "";
        for (int i = words.length - 1; i >= 0; i--) {
            int count = 0, len = words[i].length();
            for (int j = 1; j < len; j++) {
                String s = words[i].substring(0, j);
                if (!set.contains(s)) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == len - 1) {
                if (res.equals("") || len > res.length())
                    res = words[i];
                else if (len == res.length())
                    res = res.compareTo(words[i]) < 0 ? res : words[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: \"world\", Output: \"" + solution.longestWord(new String[]{"w","wo","wor","worl", "world"}) + "\"");

        System.out.println("Expected: \"apple\", Output: \"" + solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}) + "\"");
    }
}