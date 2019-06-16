class TicTacToe {

    /** Initialize your data structure here. */
    int n;
    int[][] arr;
    public TicTacToe(int n) {
        this.n = n;
        this.arr = new int[n][n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        this.arr[row][col] = player;

        if (isGameEnd(row, col)) {
            return player;
        }
        return 0;
    }

    public boolean isGameEnd(int row, int col) {
        boolean winRow = true, winCol = true, winDig = true,
                winAntiDig = true;
        for (int i = 1; i < this.n; i++) {
            if (this.arr[row][i - 1] != this.arr[row][i]) {
                winRow = false;
            }

            if (this.arr[i - 1][col] != this.arr[i][col]) {
                winCol = false;
            }
        }

        if (row == col) {
            for (int i = 1; i < this.n; i++) {
                if (this.arr[i - 1][i - 1] != this.arr[i][i])
                    winDig = false;
            }
        } else {
            winDig = false;
        }

        if (row + col == this.n - 1) {
            for (int i = 1; i < this.n; i++) {
                if (this.arr[i - 1][this.n - i] != this.arr[i][this.n - i  -1])
                    winAntiDig = false;
            }
        } else {
            winAntiDig = false;
        }
        return winRow || winCol || winDig || winAntiDig;
    }

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);
        System.out.println(toe.move(0, 0, 1));

        System.out.println(toe.move(0, 2, 2));

        System.out.println(toe.move(2, 2, 1));

        System.out.println(toe.move(1, 1, 2));

        System.out.println(toe.move(2, 0, 1));

        System.out.println(toe.move(1, 0, 2));

        System.out.println(toe.move(2, 1, 1));
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */