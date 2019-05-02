import java.util.Arrays;

class Solution {

    /**
     * Leetcode 455. Assign Cookies
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = g.length-1;
        int res = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            if (j < 0) {
                break;
            }

            if (s[i] >= g[j]) {
                res++; j--;
            } else {
                i++; j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] g = new int[]{1, 2, 3}, s = new int[]{1, 1};
        System.out.println("Expected: 1, Output: " + sol.findContentChildren(g, s));

        int[] g1 = new int[]{1, 2}, s1 = new int[]{1, 2, 3};
        System.out.println("Expected: 2, Output: " + sol.findContentChildren(g1, s1));
    }
}