class Pair{

    int row;
    int col;

    Pair(int row,int col){

        this.row = row;
        this.col = col;
        
    }
}


class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        Queue<Pair> q = new LinkedList<>();
        boolean[][] b = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for ( int j = 0; j < cols; j++ ) {
                if ( grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
            }
        }

        while (!q.isEmpty()) {

            int size = q.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();

                if (p.col + 1 < cols && grid[p.row][p.col + 1] == 1 && !b[p.row][p.col + 1]) {
                    grid[p.row][p.col + 1] = 2;
                    q.add(new Pair(p.row, p.col + 1));
                    b[p.row][p.col + 1] = true;
                    flag = true;
                }

                if (p.col - 1 >= 0 && grid[p.row][p.col - 1] == 1 && !b[p.row][p.col - 1]) {
                    grid[p.row][p.col-1] = 2;
                    q.add(new Pair(p.row, p.col - 1));
                    b[p.row][p.col - 1] = true;
                    flag = true;

                }

                if (p.row + 1 < rows && grid[p.row + 1][p.col] == 1 && !b[p.row + 1][p.col]) {
                    grid[p.row+1][p.col] = 2;
                    q.add(new Pair(p.row + 1, p.col));
                    b[p.row + 1][p.col] = true;
                    flag = true;

                }

                if (p.row - 1 >= 0  && grid[p.row - 1][p.col] == 1 && !b[p.row - 1][p.col]) {
                    grid[p.row-1][p.col] = 2;
                    q.add(new Pair(p.row - 1, p.col));
                    b[p.row - 1][p.col] = true;
                    flag = true;

                }
            }
            
            if (flag){
                count++;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        if (count >= 0) {
            return count;
        } else {
            return -1;
        }
    }
}