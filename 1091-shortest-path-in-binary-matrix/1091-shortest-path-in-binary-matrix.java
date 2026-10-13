class Pair {
    int x;
    int y;
    int d;

    Pair(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[][] b = new boolean[n][m];
        int sd = -1;

        q.add(new Pair(0, 0, 1));
        b[0][0] = true;

        while (!q.isEmpty()) {

            Pair p = q.poll();

            if (p.x == n - 1 && p.y == m - 1) {
                if (sd == -1 || p.d < sd) {
                    sd = p.d;
                }
            }

            if (p.x - 1 >= 0 &&grid[p.x - 1][p.y] == 0 &&!b[p.x - 1][p.y]) {

                q.add(new Pair(p.x - 1, p.y, p.d + 1));
                b[p.x - 1][p.y] = true;
            }

            if (p.x + 1 < n && grid[p.x + 1][p.y] == 0 && !b[p.x + 1][p.y]) {
                q.add(new Pair(p.x + 1, p.y, p.d + 1));
                b[p.x + 1][p.y] = true;
            }

            if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 0 && !b[p.x][p.y - 1]) {

                q.add(new Pair(p.x, p.y - 1, p.d + 1));
                b[p.x][p.y - 1] = true;
            }

            if (p.y + 1 < m && grid[p.x][p.y + 1] == 0 && !b[p.x][p.y + 1]) {

                q.add(new Pair(p.x, p.y + 1, p.d + 1));
                b[p.x][p.y + 1] = true;
            }

            if (p.x - 1 >= 0 && p.y - 1 >= 0 && grid[p.x - 1][p.y - 1] == 0 && !b[p.x - 1][p.y - 1]) {

                q.add(new Pair(p.x - 1, p.y - 1, p.d + 1));
                b[p.x - 1][p.y - 1] = true;
            }

            if (p.x - 1 >= 0 && p.y + 1 < m && grid[p.x - 1][p.y + 1] == 0 && !b[p.x - 1][p.y + 1]) {

                q.add(new Pair(p.x - 1, p.y + 1, p.d + 1));
                b[p.x - 1][p.y + 1] = true;
            }

            if (p.x + 1 < n && p.y - 1 >= 0 &&grid[p.x + 1][p.y - 1] == 0 &&!b[p.x + 1][p.y - 1]) {
                q.add(new Pair(p.x + 1, p.y - 1, p.d + 1));
                b[p.x + 1][p.y - 1] = true;
            }

            if (p.x + 1 < n && p.y + 1 < m &&grid[p.x + 1][p.y + 1] == 0 &&!b[p.x + 1][p.y + 1]) {
                q.add(new Pair(p.x + 1, p.y + 1, p.d + 1));
                b[p.x + 1][p.y + 1] = true;
            }
        }

        return sd;
    }
}