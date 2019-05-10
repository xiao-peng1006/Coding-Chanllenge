class Solution {

    /**
     * Leetcode 507. Perfect Number
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 0)
            return false;
        int sum = 0;
        for (int i = 1; i <= num/2; i++) {
            if (num%i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: true, Output: " + solution.checkPerfectNumber(28));
    }
}