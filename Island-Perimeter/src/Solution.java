class Solution {

    /**
     * Leetcode 463. Island Perimeter
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;

                    if (i > 0 && grid[i - 1][j] == 1)
                        res -= 2;

                    if (j > 0 && grid[i][j - 1] == 1)
                        res -= 2;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};

        System.out.println("Expected: 16, Output: " + solution.islandPerimeter(grid));
    }
}