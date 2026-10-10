class Solution {
    public int maxSubArray(int[] nums) {
        

        if (nums.length == 1){
            if (nums[0] < 0){
                return -1;
            }else{
                return nums[0];
            }
        }

        int sum = 0;
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++){

            sum += nums[i];

            if (sum > maxSum){
                maxSum = sum;
            }

            if (sum < 0){
                sum = 0;
            }
        }

        return maxSum;
    }
}