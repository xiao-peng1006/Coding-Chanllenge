class Solution {
    int maxRow, maxCol;
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.maxRow = m;
        this.maxCol = n;
        this.memo = new int[m][n];
        return dp(1 ,1);
    }

    public  int dp(int row, int col) {
        if (row == maxRow || col == maxCol) {
            return 1;
        }

        if (memo[row][col] != 0)
            return memo[row][col];

        memo[row][col] = dp(row + 1, col) + dp(row, col + 1);
        return memo[row][col];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.uniquePaths(3, 2));

        System.out.println("Expected: 28, Output: " + solution.uniquePaths(7, 3));
    }
}