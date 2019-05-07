import java.util.LinkedList;
import java.util.Queue;

class Solution {

    /**
     * Leetcode 994. Rotting Oranges
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    ((LinkedList<int[]>) queue).add(new int[]{i, j});
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            // if using queue.size() for loop condition, it will change every time when new item is added to the queue
            for (int k = 0; k < len; k++) {
                int[] temp = ((LinkedList<int[]>) queue).remove();
                int row = temp[0], col = temp[1];
                for (int[] i : new int[][]{{row - 1, col}, {row + 1, col}, {row, col - 1}, {row, col + 1}}) {
                    if (i[0] >= 0 && i[1] >= 0 && i[0] < grid.length && i[1] < grid[0].length && grid[i[0]][i[1]] == 1) {
                        grid[i[0]][i[1]] = 2;
                        count--;
                        ((LinkedList<int[]>) queue).add(new int[]{i[0], i[1]});
                    }
                }
            }
            res++;
        }
        return count == 0 ? Math.max(0, res-1) : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("Expected: 4, Output: " + solution.orangesRotting(grid));

        grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println("Expected: -1, Output: " + solution.orangesRotting(grid));

        grid = new int[][]{{0, 2}};
        System.out.println("Expected: 0, Output: " + solution.orangesRotting(grid));

        grid = new int[][]{{0, 2, 2}};
        System.out.println("Expected: 0, Output: " + solution.orangesRotting(grid));

        grid = new int[][]{{1, 2, 1, 1, 2, 1, 1}};
        System.out.println("Expected: 2, Output: " + solution.orangesRotting(grid));
    }
}