import java.util.HashSet;
import java.util.Set;

class Solution {
    int[][] grid;
    boolean[][] seen;
    Set<Integer> shape;

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set shapes = new HashSet<HashSet<Integer>>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                shape = new HashSet<Integer>();
                helper(r, c, r, c);
                if (!shape.isEmpty()) {
                    shapes.add(shape);
                }
            }
        }

        return shapes.size();
    }

    public void helper(int r, int c, int r0, int c0) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                grid[r][c] == 1 && !seen[r][c]) {

            seen[r][c] = true;

            shape.add((r - r0) * 2 * grid[0].length + (c - c0));
            helper(r + 1, c, r0, c0);
            helper(r - 1, c, r0, c0);
            helper(r, c + 1, r0, c0);
            helper(r, c - 1, r0, c0);
        }
    }
}