class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        
        int sInc = 1;
        int sDec = 1;
        int maxInc = 1;
        int maxDec = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i-1] > nums[i]) {
                sDec += 1;
                maxDec = Math.max(maxDec,sDec);
            } else {
                sDec = 1;
            }

            if (nums[i-1] < nums[i]) {
                sInc += 1;
                maxInc = Math.max(maxInc,sInc);
            } else {
                sInc = 1;
            }
        }

        return Math.max(maxInc,maxDec);
    }
}