class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int countIslands(int[][] grid, int k) {

        Queue<Pair> q = new LinkedList<>();
        boolean[][] b = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (!b[i][j] && grid[i][j] != 0) {

                    long sum = grid[i][j];
                    q.add(new Pair(i, j));
                    b[i][j] = true;

                    while (!q.isEmpty()) {

                        Pair p = q.poll();

                        if (p.x - 1 >= 0 &&!b[p.x - 1][p.y] && grid[p.x - 1][p.y] != 0) {

                            b[p.x - 1][p.y] = true;
                            sum += grid[p.x - 1][p.y];
                            q.add(new Pair(p.x - 1, p.y));
                        }

                        if (p.x + 1 < grid.length &&!b[p.x + 1][p.y] && grid[p.x + 1][p.y] != 0) {

                            b[p.x + 1][p.y] = true;
                            sum += grid[p.x + 1][p.y];
                            q.add(new Pair(p.x + 1, p.y));
                        }

                        if (p.y - 1 >= 0 &&!b[p.x][p.y - 1] && grid[p.x][p.y - 1] != 0) {

                            b[p.x][p.y - 1] = true;
                            sum += grid[p.x][p.y - 1];
                            q.add(new Pair(p.x, p.y - 1));
                        }

                        if (p.y + 1 < grid[0].length &&!b[p.x][p.y + 1] && grid[p.x][p.y + 1] != 0) {

                            b[p.x][p.y + 1] = true;
                            sum += grid[p.x][p.y + 1];
                            q.add(new Pair(p.x, p.y + 1));
                        }
                    }

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
