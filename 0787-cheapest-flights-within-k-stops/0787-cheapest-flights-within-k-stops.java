class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int arr[] = new int[n];
        Arrays.fill(arr, 100000);
        arr[src] = 0;

        for (int i = 0; i <= k; i++) {

            int temp[] = Arrays.copyOf(arr, n);

            for (int j = 0; j < flights.length; j++) {

                int u = flights[j][0];
                int v = flights[j][1];
                int w = flights[j][2];

                if (arr[u] != 100000 && arr[u] + w < temp[v]) {
                    temp[v] = arr[u] + w;
                }
            }

            arr = temp;
        }

        if (arr[dst] == 100000) {
            return -1;
        } else {
            return arr[dst];
        }
    }
}