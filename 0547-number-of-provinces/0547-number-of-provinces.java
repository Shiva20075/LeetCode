class Solution {
    public int findCircleNum(int[][] isConnected) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] b = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++){

            if (!b[i]){

                count++;
                q.add(i);
                b[i] = true;

                while (!q.isEmpty()){

                    int node = q.poll();

                    for (int j = 0; j < isConnected.length; j++){

                        if (isConnected[node][j] == 1 && !b[j]) 
                        { 
                            b[j] = true; 
                            q.add(j); 
                        }
                    }
                }
            }
        }
        return count;
    }
}