class Solution {

    /**
     * Leetcode 463. Island Perimeter
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                } else {
                    continue;
                }

                if (i > 0 && grid[i-1][j] == 1)
                    res -= 1;

                if (i+1 < grid.length && grid[i+1][j] == 1)
                    res -= 1;

                if (j > 0 && grid[i][j-1] == 1)
                    res -= 1;

                if (j+1 < grid[0].length && grid[i][j+1] == 1)
                    res -= 1;
                System.out.println(res);
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