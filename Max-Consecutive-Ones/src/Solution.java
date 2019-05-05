class Solution {

    /**
     * Leetcode 485. Max Consecutive Ones
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int num:nums) {
            if (num == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        res = Math.max(res, count);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}