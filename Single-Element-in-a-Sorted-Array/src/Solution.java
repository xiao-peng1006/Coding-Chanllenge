class Solution {

    /**
     * Leetcode 540. Single Element in a Sorted Array
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid == 0) return nums[mid];
            // can be rewritten as "if (nums[mid] == nums[mid ^ 1])"
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 != 0 && nums[mid] == nums[mid - 1])) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 2, Output: " + solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));

        System.out.println("Expected: 10, Output: " + solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}