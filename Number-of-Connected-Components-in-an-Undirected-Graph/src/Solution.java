class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] visited = new int[n];
        int count = 0;

        for (int i = 0; i < edges.length; i++) {
            if (visited[edges[i][0]] != 1) {
                dfs(n, edges, edges[i][0], visited);
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0)
                count++;
        }
        return count;
    }

    public void dfs(int n, int[][] edges, int index, int[] visted) {
        if (index > n - 1 || visted[index] == 1) {
            return;
        }

        visted[index] = 1;

        for (int i = 0; i < edges.length; i++) {
            if (index == edges[i][0]) {
                dfs(n, edges, edges[i][1], visted);
            }

            if (index == edges[i][1]) {
                dfs(n, edges, edges[i][0], visted);
            }
        }
    }
}