class Solution {
    public String removeDuplicates(String S) {
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                S = S.substring(0, i - 1) + S.substring(i + 1, S.length());
                i = 0;
            }
        }
        return S;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("aaaaa"));
    }
}