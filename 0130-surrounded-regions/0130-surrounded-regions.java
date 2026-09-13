class Pair{

    int row;
    int col;

    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}


class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] b = new boolean[row][col];

        for (int i = 0; i < row; i++ ) {
            for (int j = 0; j < col; j++) {
                if ( board[i][j] == 'O' && !b[i][j] && (i == 0 || i == row - 1 || j == 0 || j == col-1)) {

                    q.add(new Pair(i,j));
                    b[i][j] = true;

                    while ( !q.isEmpty()) {

                        Pair p = q.poll();

                        if (p.col + 1 < col && board[p.row][p.col + 1] == 'O' && !b[p.row][p.col + 1]) {
                            q.add(new Pair(p.row, p.col + 1));
                            b[p.row][p.col + 1] = true;
                        }

                        if (p.col - 1 >= 0 && board[p.row][p.col - 1] == 'O' && !b[p.row][p.col - 1]) {
                            q.add(new Pair(p.row, p.col - 1));
                            b[p.row][p.col - 1] = true;
                        }

                        if (p.row + 1 < row && board[p.row + 1][p.col] == 'O' && !b[p.row + 1][p.col]) {
                            q.add(new Pair(p.row + 1, p.col));
                            b[p.row + 1][p.col] = true;
                        }

                        if (p.row - 1 >= 0 && board[p.row - 1][p.col] == 'O' && !b[p.row - 1][p.col]) {
                            q.add(new Pair(p.row - 1, p.col));
                            b[p.row - 1][p.col] = true;
                        }

                    }
                }
            } 
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++ ) {
                if (board[i][j] == 'O' && !b[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}