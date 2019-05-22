import java.util.Arrays;

class Solution {

    /**
     * Leetcode 807. Max Increase to Keep City Skyline
     * @param grid
     * @return
     */
    int[][] grid;
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        this.grid = grid;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int rowMax = getMaxRow(i);
            for (int j = 0; j < grid[0].length; j++) {
                int colMax = getMaxCol(j);
                if (grid[i][j] == rowMax || grid[i][j] == colMax)
                    continue;
                res += Math.min(rowMax, colMax) - grid[i][j];
            }
        }
        return res;
    }

    private int getMaxRow(int row) {
        int rowMax = grid[row][0];
        for (int i = 1; i < grid[row].length; i++) {
            rowMax = Math.max(rowMax, grid[row][i]);
        }
        return rowMax;
    }

    private int getMaxCol(int col) {
        int colMax = grid[0][col];
        for (int i = 1; i < grid.length; i++) {
            colMax = Math.max(colMax, grid[i][col]);
        }
        return colMax;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 35, Output: " + solution.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }
}