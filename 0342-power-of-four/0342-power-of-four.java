class Solution {
    public boolean isPowerOfFour(int n) {
        
        return checkPower((long)n,1);
    }

    public boolean checkPower(long n,long four) {

        if (n == four) {
            return true;
        }

        if (n > four) {
            return checkPower(n,four*4);
        }

        return false;
    }
}