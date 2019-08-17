import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(String s, int start, List<String> temp, List<List<String>> list) {
        if (start == s.length()) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            // 如果string是palindrome,则继续dfs,否则往后扩展当前string
            if (isPalindrome(str)) {
                temp.add(str);
                dfs(s, i + 1, temp, list);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++; right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}