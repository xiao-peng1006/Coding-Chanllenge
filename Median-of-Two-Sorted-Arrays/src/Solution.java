class Solution {

    /**
     * Leetcode 4. Median of Two Sorted Arrays
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0, count = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        while (i < nums1.length)
            nums[count++] = nums1[i++];

        while (j < nums2.length)
            nums[count++] = nums2[j++];

        if (count%2 == 0) {
            return (double)(nums[count/2] + nums[count/2-1])/2;
        } else {
            return nums[count/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        Solution sol = new Solution();

        System.out.println("Expected: 2.5, Output: " + sol.findMedianSortedArrays(nums1, nums2));
    }
}