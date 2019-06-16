class Solution {
    int[][] rooms;
    public void wallsAndGates(int[][] rooms) {
        this.rooms = rooms;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0)
                    dfs(i, j, 0);
            }
        }
    }

    public void dfs( int row, int col, int distance) {
        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length || rooms[row][col] < distance) {
            return;
        }

        rooms[row][col] = distance;

        dfs(row - 1, col, distance + 1);
        dfs(row + 1, col, distance + 1);
        dfs(row, col - 1, distance + 1);
        dfs(row, col + 1, distance + 1);
    }
}