class Solution {

    /**
     * Leetcode 26. Remove Duplicates from Sorted Array
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0, pre = nums[0]^512;
        for (int num:nums) {
            if (num != pre) {
                nums[count++] = num;
                pre = num;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}