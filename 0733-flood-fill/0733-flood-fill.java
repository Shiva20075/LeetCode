class pair {
    
    int row;
    int col;

    pair(int row, int col) {
        this.col = col;
        this.row = row;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<pair> q = new LinkedList<>();
        boolean[][] b = new boolean[image.length][image[0].length];

        int rows = image.length;
        int cols = image[0].length;
        int prevColour = image[sr][sc];

        pair p = new pair(sr, sc);
        q.add(new pair(p.row, p.col));
        b[p.row][p.col] = true;

        while (!q.isEmpty()) {

            pair curr = q.poll();
            image[curr.row][curr.col] = color;

            if (curr.row - 1 >= 0 && !b[curr.row - 1][curr.col] && image[curr.row - 1][curr.col] == prevColour) {
                q.add(new pair(curr.row - 1, curr.col));
                b[curr.row - 1][curr.col] = true;
            }

            if (curr.row + 1 < rows && !b[curr.row + 1][curr.col] && image[curr.row + 1][curr.col] ==prevColour){
                q.add(new pair(curr.row + 1, curr.col));
                b[curr.row + 1][curr.col] = true;
            }

            if (curr.col - 1 >= 0 && !b[curr.row][curr.col - 1] && image[curr.row][curr.col - 1] == prevColour) {
                q.add(new pair(curr.row, curr.col - 1));
                b[curr.row][curr.col - 1] = true;
            }

            if (curr.col + 1 < cols && !b[curr.row][curr.col + 1] && image[curr.row][curr.col + 1] ==prevColour){
                q.add(new pair(curr.row, curr.col + 1));
                b[curr.row][curr.col + 1] = true;
            }
        }

        return image;
    }
}