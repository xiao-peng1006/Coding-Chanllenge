class Solution {

    /**
     * Leetcode 200. Number of Islands
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void helper(char[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            if (grid[row][col] == '0') {
                return;
            }

            grid[row][col] = '0';
            helper(grid, row - 1, col);
            helper(grid, row + 1, col);
            helper(grid, row, col - 1);
            helper(grid, row, col + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid  = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        Solution sol = new Solution();

        System.out.println("Expected: 1, Output: " + sol.numIslands(grid));

        char[][] grid2  = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println("Expected: 3, Output: " + sol.numIslands(grid2));
    }
}