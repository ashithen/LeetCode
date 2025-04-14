package org.practice.meta;

public class MineSweeper {

    private int[][] neighbours;

    int m;
    int n;
    char[][] board;

    private void setNeighbours(){
        neighbours = new int[8][2];
        int k=0;
        for (int i=-1; i<=1; i++){
            for (int j=-1; j<=1; j++){
                if (i==0 && j==0) continue;
                neighbours[k++] = new int[]{i,j};
            }
        }
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    private int getNumberOfMines( int r, int c) {
        int count = 0;
        for (int[] pos : neighbours) {
            int nr = r + pos[0];
            int nc = c + pos[1];
            if (isValid(nr, nc) && this.board[nr][nc] == 'M') {
                count++;
            }
        }
        return count;
    }

    private void reveal(int r, int c) {
        if (this.board[r][c] != 'E'){
            return;
        }
        int mCount = getNumberOfMines(r, c);
        if (mCount == 0){
            this.board[r][c] = 'B';
            for (int[] pos : neighbours) {
                int nr = r + pos[0];
                int nc = c + pos[1];
                if (isValid(nr, nc)) {
                    this.reveal(nr, nc);
                }
            }
        }
        else {
            this.board[r][c] = Character.forDigit(mCount, 10);
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        setNeighbours();

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else if (board[click[0]][click[1]] == 'E') {
            this.reveal(click[0], click[1]);
        }
        return board;
    }
}
