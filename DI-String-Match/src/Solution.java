class Solution {

    /**
     * Leetcode 942. DI String Match
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
        int low = 0, high = S.length();
        int[] res = new int[S.length()+1];

        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (c == 'I') {
                res[i] = low++;
            }
            if (c == 'D') {
                res[i] = high--;
            }
        }
        res[S.length()] = low;
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String S = "IDID";
        StringBuilder sb = new StringBuilder();
        int[] res = sol.diStringMatch(S);
        sb.append('[');
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1) {
                sb.append(res[i] + ", ");
            } else {
                sb.append(res[i]);
            }
        }
        sb.append(']');
        System.out.println("Expected: [0, 4, 1, 3, 2], Output: " + sb.toString());

        S = "III";
        res = sol.diStringMatch(S);
        sb.setLength(0);
        sb.append('[');
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1) {
                sb.append(res[i] + ", ");
            } else {
                sb.append(res[i]);
            }
        }
        sb.append(']');
        System.out.println("Expected: [0, 1, 2, 3], Output: " + sb.toString());

        S = "DDI";
        res = sol.diStringMatch(S);
        sb.setLength(0);
        sb.append('[');
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1) {
                sb.append(res[i] + ", ");
            } else {
                sb.append(res[i]);
            }
        }
        sb.append(']');
        System.out.println("Expected: [3, 2, 0, 1], Output: " + sb.toString());
    }
}