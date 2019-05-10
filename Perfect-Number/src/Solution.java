class Solution {

    /**
     * Leetcode 507. Perfect Number
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;
        int sum = 1;
        for (int i = 2; i*i < num; i++) {
            if (num % i == 0) {
                int r = num/i;
                if (i == r) {
                    sum += i;
                } else {
                    sum += i + r;
                }
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: true, Output: " + solution.checkPerfectNumber(28));
    }
}