class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }

       int ans =  findk(piles,1,max,h);
       return ans;
    }

    public int findk(int[] piles,int min,int max,int h){
        int l = min;
        int r = max;
        int ans = 0;

        while (l <= r){
            int mid = (l + r)/2;
            int temp = checkK(mid,h,piles);

            if (temp > h){
                l = mid + 1;
            }

            if (temp <= h){
                ans = mid;
                r = mid - 1;
            }

        }

        return ans;
    }

    public int checkK(int mid,int h,int[] arr){
        int rs = 0;
        for (int i = 0; i < arr.length; i++){
            rs += Math.ceil((double) arr[i]/mid);
        }
        return rs;
    }
}