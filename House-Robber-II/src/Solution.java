class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int pprev = nums[0], prev = Math.max(pprev, nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int temp = prev;
            prev = Math.max(prev, nums[i] + pprev);
            pprev = temp;
        }
        int res = prev;
        pprev = 0; prev = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int temp = prev;
            prev = Math.max(prev, nums[i] + pprev);
            pprev = temp;
        }
        return Math.max(res, prev);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.rob(new int[]{2, 3, 2}));
        System.out.println("Expected: 4, Output: " + solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println("Expected: 3, Output: " + solution.rob(new int[]{2, 1, 1, 1, 2}));
        System.out.println("Expected: 7, Output: " + solution.rob(new int[]{1, 4, 2, 3, 1}));
    }
}