class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j++) {
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 49, Output: " + solution.maxArea(new int[]{1, 8, 5, 2, 5, 4, 8, 3, 7}));
    }
}