class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m*n];
        int[][] dir = {{-1, 1}, {1, -1}};
        int r = 0, c = 0, k = 0;
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[r][c];
            r += dir[k][0];
            c += dir[k][1];
            if (r >= m) {
                r = m - 1;
                c += 2;
                k = 1 - k;
            }
            if (c >= n) {
                c = n - 1;
                r += 2;
                k = 1 - k;
            }
            if (r < 0) {
                r = 0;
                k = 1 - k;
            }
            if (c < 0) {
                c = 0;
                k = 1 - k;
            }
        }
        return res;
    }
}