class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int min = piles[0];
        int max = piles[0];

        for (int i = 0; i < piles.length; i++){

            if (piles[i] > max){
                max = piles[i];
            }

            if (piles[i] < min){
                min = piles[i];
            }
            
        }

        int k = findSpeed(piles,h,min,max);
        return k;
        
    }

    public int findSpeed(int[] piles,int h,int min,int max){

        int low = 1;
        int high = max;
        int ans = 0;

        while (low <= high){

            int mid = (low + high)/2;

            int k = findK(low,high,mid,h,piles);

            if ( k <= h){
                ans = mid;
                high = mid - 1;
            }

            if (k > h){
                low  = mid + 1;
            }
        }

        return ans;
    }

    public int findK(int low , int hight,int mid,int h,int[] piles){
        int temp = 0;
        for (int i = 0; i < piles.length; i++){
            temp += Math.ceil((double) piles[i]/mid);
        }
        return temp;
    }
}