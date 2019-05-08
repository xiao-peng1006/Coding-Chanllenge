import java.util.Arrays;

class Solution {

    /**
     * Leetcode 628. Maximum Product of Three Numbers
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[0] >= 0 || nums[len-1] <= 0) {
            return nums[len-1]*nums[len-2]*nums[len-3];
        }

        if (nums[0]*nums[1] > nums[len-2]*nums[len-3])
            return nums[0]*nums[1]*nums[len-1];
        else
            return nums[len-1]*nums[len-2]*nums[len-3];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 6, Output: " + solution.maximumProduct(new int[]{1, 2, 3}));

        System.out.println("Expected: 24, Output: " + solution.maximumProduct(new int[]{1, 2, 3, 4}));

        System.out.println("Expected: -6, Output: " + solution.maximumProduct(new int[]{-4, -1, -2, -3}));

        System.out.println("Expected: 60, Output: " + solution.maximumProduct(new int[]{-4, -3, -1, 0, 2, 4, 5}));

        System.out.println("Expected: 0, Output: " + solution.maximumProduct(new int[]{-4, 0, 2, 3}));

    }
}