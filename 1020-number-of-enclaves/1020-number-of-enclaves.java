class Pair{

    int row;
    int col;

    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}


class Solution {
    public int numEnclaves(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] b = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++ ) {
                
                if (grid[i][j] == 1 && !b[i][j] && (i == 0 || i == row - 1 || j == 0 || j == col - 1)){
                    
                    q.add(new Pair(i,j));
                    b[i][j] = true;

                    while (!q.isEmpty()){  
                        
                        Pair p = q.poll();

                        if (p.col + 1 < col && grid[p.row][p.col + 1] == 1 && !b[p.row][p.col + 1]) {
                            q.add(new Pair(p.row, p.col + 1));
                            b[p.row][p.col + 1] = true;
                        }

                        if (p.col - 1 >= 0 && grid[p.row][p.col - 1] == 1 && !b[p.row][p.col - 1]) {
                            q.add(new Pair(p.row, p.col - 1));
                            b[p.row][p.col - 1] = true;
                        }

                        if (p.row + 1 < row && grid[p.row + 1][p.col] == 1 && !b[p.row + 1][p.col]) {
                            q.add(new Pair(p.row + 1, p.col));
                            b[p.row + 1][p.col] = true;
                        }

                        if (p.row - 1 >= 0 && grid[p.row - 1][p.col] == 1 && !b[p.row - 1][p.col]) {
                            q.add(new Pair(p.row - 1, p.col));
                            b[p.row - 1][p.col] = true;
                        }
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!b[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}