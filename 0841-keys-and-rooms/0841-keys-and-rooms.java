class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean bool[] = new boolean[rooms.size()];        
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(rooms.get(0));;
        bool[0] = true;

        while (!q.isEmpty()) {

            List<Integer> l = q.poll();

            for (int i = 0; i < l.size(); i++) {
                if (!bool[l.get(i)]) {
                    bool[l.get(i)] = true;
                    q.add(rooms.get(l.get(i)));
                }
            }
           
        }

        for (int i = 0; i < rooms.size(); i++) {

            if (bool[i] == false) {
                return false;
            }
        } 

        return true;
    }
}