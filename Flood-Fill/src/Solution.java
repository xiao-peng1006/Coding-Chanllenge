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
        int curColor = image[sr][sc];
        helper(image, new boolean[image.length][image[0].length], sr, sc, newColor, curColor);
        return image;
    }

    public void helper(int[][] image, boolean[][] visited, int row, int col, int newColor, int curColor) {
        if (image[row][col] != curColor) {
            return;
        } else {
            image[row][col] = newColor;
            visited[row][col] = true;
            if (row > 0 && !visited[row-1][col]) helper(image, visited, row-1, col, newColor, curColor);
            if (row < image.length-1 && !visited[row+1][col]) helper(image, visited,row+1, col, newColor, curColor);
            if (col > 0 && !visited[row][col-1]) helper(image, visited, row, col-1, newColor, curColor);
            if (col < image[0].length-1 && !visited[row][col+1]) helper(image, visited, row, col+1, newColor, curColor);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = new int[][]{{1,1,1}, {1,1,0}, {1,0,1}};

    }
}