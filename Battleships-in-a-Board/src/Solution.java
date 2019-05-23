class Solution {

    /**
     * Leetcode 419. Battleships in a Board
     *
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        int res = 0;
        if (board == null || board.length == 0)
            return res;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    res ++;
                    helper(board, i, j);
                }
            }
        }
        return res;
    }

    public void helper(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '.')
            return;
        else {
            board[row][col] = '.';
            helper(board, row - 1, col);
            helper(board, row + 1, col);
            helper(board, row, col - 1);
            helper(board, row, col + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.countBattleships(new char[][]{{'.','.','.','X'},{'X','X','X','.'},{'.','.','.','X'}}));
    }
}