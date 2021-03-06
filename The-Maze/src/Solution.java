import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] startPosition = queue.remove();
            if (startPosition[0] == destination[0] && startPosition[1] == destination[1]) {
                return true;
            }
            for (int[] direction : directions) {
                int x = startPosition[0] + direction[0];
                int y = startPosition[1] + direction[1];
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += direction[0];
                    y += direction[1];
                }
                if (!visited[x - direction[0]][y - direction[1]]) {
                    queue.add(new int[]{x - direction[0], y - direction[1]});
                    visited[x - direction[0]][y - direction[1]] = true;
                }
            }
        }
        return false;
    }
}