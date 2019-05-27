class Solution {

    /**
     * Leetcode 695. Max Area of Island
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0)
            return res;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, help(grid, i, j));
                }
            }
        }
        return res;
    }

    private int help(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        return 1 + help(grid, row - 1, col) + help(grid, row + 1, col) + help(grid, row, col - 1) + help(grid, row, col + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}