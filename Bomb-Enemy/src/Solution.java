class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int maxKills = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    maxKills = Math.max(maxKills, helper(grid, i, j));
                }
            }
        }
        return maxKills;
    }

    public int helper(char[][] grid, int row, int col) {
        int res = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int r = row + direction[0];
            int c = col + direction[1];
            while (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 'W') {

                if (grid[r][c] == 'E') {
                    System.out.println("Arrived here!");
                    res++;
                }
                r += direction[0];
                c += direction[1];
            }
        }
        return res;
    }
}