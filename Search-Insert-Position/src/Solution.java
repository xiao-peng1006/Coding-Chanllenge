class Solution {

    /**
     * Leetcode 35. Search Insert Position
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0])
            return 0;
        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i])
                return i;
            if (target > nums[i-1] && target < nums[i])
                return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 2, Output: " + solution.searchInsert(new int[]{1, 3, 5, 6}, 5));

        System.out.println("Expected: 1, Output: " + solution.searchInsert(new int[]{1, 3, 5, 6}, 2));

        System.out.println("Expected: 4, Output: " + solution.searchInsert(new int[]{1, 3, 5, 6}, 7));

        System.out.println("Expected: 0, Output: " + solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}