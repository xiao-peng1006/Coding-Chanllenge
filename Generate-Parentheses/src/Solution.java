import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 22
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(n, 0, 0, "", res);
        return res;
    }

    private void helper(int n, int open, int close, String temp, List<String> res) {
        if (open == n && close == n) {
            res.add(temp);
            return;
        }

        if (open < n)
            helper(n, open+1, close, temp + "(", res);
        if (close < open) {
            helper(n, open, close+1, temp + ")", res);
        }
    }

    public static void main(String[] args) {
        int n;
        List<String> res;
        Solution sol = new Solution();
        StringBuilder sb = new StringBuilder();

        n = 3;
        res = sol.generateParenthesis(n);
        System.out.println("Expected: [\n" +
                "  \"((()))\",\n" +
                "  \"(()())\",\n" +
                "  \"(())()\",\n" +
                "  \"()(())\",\n" +
                "  \"()()()\"\n" +
                "]");

        sb.append("[\n");
        for (String s:res) {
            sb.append("  \"").append(s).append("\",\n");
        }
        sb.append("]");
        System.out.println("Output: " + sb.toString());


    }
}