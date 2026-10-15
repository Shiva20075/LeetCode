class Solution {

    class Pair {
        int diff;
        int row;
        int col;

        Pair(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        int[][] maxDiff = new int[n][m];

        for (int[] row : maxDiff) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new java.util.PriorityQueue<>((a, b) -> Integer.compare(a.diff, b.diff));
        maxDiff[0][0] = 0;
        pq.add(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {

            Pair p = pq.poll();
            int diff = p.diff;
            int row = p.row;
            int col = p.col;

            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            if (row - 1 >= 0) {

                int currDiff = Math.abs(heights[row - 1][col] - heights[row][col]);
                int newDiff = Math.max(diff, currDiff);

                if (newDiff < maxDiff[row - 1][col]) {
                    maxDiff[row - 1][col] = newDiff;
                    pq.add(new Pair(newDiff, row - 1, col));
                }
            }

            if (col - 1 >= 0) {

                int currDiff = Math.abs(heights[row][col - 1] - heights[row][col]);
                int newDiff = Math.max(diff, currDiff);

                if (newDiff < maxDiff[row][col - 1]) {
                    maxDiff[row][col - 1] = newDiff;
                    pq.add(new Pair(newDiff, row, col - 1));
                }
            }

            if (row + 1 < n) {

                int currDiff = Math.abs(heights[row + 1][col] - heights[row][col]);
                int newDiff = Math.max(diff, currDiff);

                if (newDiff < maxDiff[row + 1][col]) {
                    maxDiff[row + 1][col] = newDiff;
                    pq.add(new Pair(newDiff, row + 1, col));
                }
            }

            if (col + 1 < m) {

                int currDiff = Math.abs(heights[row][col + 1] - heights[row][col]);
                int newDiff = Math.max(diff, currDiff);

                if (newDiff < maxDiff[row][col + 1]) {
                    maxDiff[row][col + 1] = newDiff;
                    pq.add(new Pair(newDiff, row, col + 1));
                }
            }
        }

        return 0;
    }
}
