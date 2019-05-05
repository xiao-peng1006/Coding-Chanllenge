class Solution {

    /**
     * Leetcode 733. Flood Fill
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void helper(int[][] image, int row, int col, int newColor, int curColor) {
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != curColor) {
            return;
        }
        image[row][col] = newColor;
        helper(image, row-1, col, newColor, curColor);
        helper(image, row+1, col, newColor, curColor);
        helper(image, row, col-1, newColor, curColor);
        helper(image, row, col+1, newColor, curColor);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = new int[][]{{1,1,1}, {1,1,0}, {1,0,1}};

    }
}