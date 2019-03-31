class Solution {

    /**
     *  Leetcode 771. Jewels and Stones
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() <= 0 || S == null || S.length() <= 0)
            return 0;
        int count = 0;
        for (char i:J.toCharArray()) {
            for (char s:S.toCharArray()) {
                if (i == s)
                    count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J, S;
        Solution sol = new Solution();

        J = "aA"; S = "aAAbbbb";
        System.out.println("Expected: 3, Output: " + sol.numJewelsInStones(J, S));

        J = "z"; S = "ZZ";
        System.out.println("Expected: 0, Output: " + sol.numJewelsInStones(J, S));
    }
}