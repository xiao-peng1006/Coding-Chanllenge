class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        if (n == 0 || m == 0 || indices.length == 0) return 0;
        int res = 0;
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = 0;
            }
        }

        for (int[] indice : indices) {
            for (int i = 0; i < m; i++) {
                array[indice[0]][i]++;
            }
            for (int i = 0; i < n; i++) {
                array[i][indice[1]]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] % 2 != 0) {
                    res ++;
                }
            }
        }

        return res;
    }
}