class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 0, Output: " + solution.wiggleMaxLength(new int[]{}));

        System.out.println("Expected: 6, Output: " + solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));

        System.out.println("Expected: 7, Output: " + solution.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));

        System.out.println("Expected: 2, Output: " + solution.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));

        System.out.println("Expected: 3, Output: " + solution.wiggleMaxLength(new int[]{3, 3, 3, 2, 5}));
    }
}