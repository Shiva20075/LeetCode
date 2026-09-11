class pair {
    int row;
    int col;

    pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;
        boolean[][] b = new boolean[rows][col];
        Queue<pair> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == '1' && !b[i][j]) {
                    count++;
                    q.add(new pair(i, j));
                    b[i][j] = true;

                    while (!q.isEmpty()) {
                        pair p = q.poll();

                        if (p.col + 1 < col && grid[p.row][p.col + 1] == '1' && !b[p.row][p.col + 1]) {
                            q.add(new pair(p.row, p.col + 1));
                            b[p.row][p.col + 1] = true;
                        }

                        if (p.col - 1 >= 0 && grid[p.row][p.col - 1] == '1' && !b[p.row][p.col - 1]) {
                            q.add(new pair(p.row, p.col - 1));
                            b[p.row][p.col - 1] = true;
                        }

                        if (p.row + 1 < rows && grid[p.row + 1][p.col] == '1' && !b[p.row + 1][p.col]) {
                            q.add(new pair(p.row + 1, p.col));
                            b[p.row + 1][p.col] = true;
                        }

                        if (p.row - 1 >= 0 && grid[p.row - 1][p.col] == '1' && !b[p.row - 1][p.col]) {
                            q.add(new pair(p.row - 1, p.col));
                            b[p.row - 1][p.col] = true;
                        }
                    }
                }
            }
        }

        return count;
    }
}