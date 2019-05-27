class Solution {

    /**
     * Leetcode 540. Single Element in a Sorted Array
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }

        for (int i = 1; i < nums.length; i += 2) {
            res -= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 2, Output: " + solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));

        System.out.println("Expected: 10, Output: " + solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}