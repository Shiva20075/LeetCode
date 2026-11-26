class Solution {
    public boolean canAliceWin(int n) {
        
        int Alice = 10;
        int bob = 9;
        boolean AliceTurn = true;

        while (true) {

            if (AliceTurn) {
                
                if (n < Alice) return false;
                n = n - Alice;
                Alice = Alice - 2;
                AliceTurn = false;

            } else {

                if (n < bob) return true;
                n = n - bob;
                bob = bob - 2;
                AliceTurn = true;
            }
        }
    }
}