import java.util.Arrays;

class Solution {

    /**
     * Leetcode 628. Maximum Product of Three Numbers
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int x0 = Integer.MAX_VALUE, x1 = Integer.MAX_VALUE;
        int y0 = Integer.MIN_VALUE, y1 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        for (int num:nums) {
            if (num < x1) {
                if (num < x0) {
                    x1 = x0;
                    x0 = num;
                } else {
                    x1 = num;
                }
            }

            if (num > y0) {
                if (num > y1) {
                    if (num > y2) {
                        y0 = y1;
                        y1 = y2;
                        y2 = num;
                    } else {
                        y0 = y1;
                        y1 = num;
                    }
                } else {
                    y0 = num;
                }
            }
        }
        return Math.max(x0*x1*y2, y0*y1*y2);
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