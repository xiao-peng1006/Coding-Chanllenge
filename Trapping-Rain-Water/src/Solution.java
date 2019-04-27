class Solution {

    /**
     * Leetcode 42. Trapping Rain Water
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        if (height.length == 0 || height == null) {
            return 0;
        }

        for (int i = 1; i < height.length-1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--)
                maxLeft = Math.max(height[j], maxLeft);

            for (int j = i; j < height.length; j++)
                maxRight = Math.max(height[j], maxRight);

            res += Math.min(maxLeft, maxRight) - height[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Expected: 6, Ouptut: " + sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}