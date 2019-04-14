class Solution {

    /**
     * Leetcode 79. Word Search
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || board == null)
            return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0))
                    return true;
            }
        }

        return false;

    }

    private boolean helper(char[][] board, String word, int row, int col, int index) {
        if (index >= word.length())
            return true;

        if ( row < 0 || col < 0 || col >= board[0].length || row >= board.length || word.charAt(index) != board[row][col])
            return false;


        board[row][col] ^= 512;
        boolean flag = helper(board, word, row-1, col, index+1) || helper(board, word, row+1, col, index+1) ||
                helper(board, word, row, col-1, index+1) || helper(board, word, row, col+1, index+1);
        board[row][col] ^= 512;

        return flag;
    }
}