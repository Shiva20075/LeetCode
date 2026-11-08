class Pair{

    int x;
    int y;

    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int countServers(int[][] grid) {
        
        Stack<Pair> s = new Stack<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    s.add(new Pair(i,j));
                }
            }
        }

        int ans = 0;

        while (!s.isEmpty()) {

            Pair p = s.pop();

            if (findRow(p,grid) || findCol(p,grid)) ans++;

        }

        return ans;
        
    }

    public boolean findRow(Pair p, int[][] grid) {

        int x = p.x;
        int y = p.y;

        for (int i = 0; i < grid[0].length; i++) {

            if (i == y) continue;

            if (grid[x][i] == 1) {
                return true;
            }
        }

        return false;
    }

        public boolean findCol(Pair p, int[][] grid) {

        int x = p.x;
        int y = p.y;

        for (int i = 0; i < grid.length; i++) {

            if (i == x) continue;

            if (grid[i][y] == 1) {
                return true;
            }
        }

        return false;
    }
}