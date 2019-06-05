import java.util.HashMap;

class Solution {
    int[][] M;

    public int findCircleNum(int[][] M) {
        this.M = M;
        int[] visited = new int[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(visited, i);
                res++;
            }
        }
        return res;


    }

    public void dfs(int[] visited, int i) {
        for (int j = 0; j < this.M.length; j++) {
            if (this.M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(visited, j);
            }
        }
    }
}