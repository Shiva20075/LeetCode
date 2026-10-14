class Solution {
    public int search(int[] nums, int target) {
        int index = 0;
        int n = nums.length-1;
        int start = 0;
        int end = 0;
        int mid = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[index]) {
                index = i;
            }
        }

        if ( target >= nums[index] && target <= nums[n]){
            start = index;
            end = n;
            while (start <= end){
                mid = (start + end)/2;
                if (nums[mid] == target){
                    return mid;
                }else if (nums[mid] > target){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }else {
             start = 0;
            end = index-1;
            while (start <= end){
                mid = (start + end)/2;
                if (nums[mid] == target){
                    return mid;
                }else if (nums[mid] > target){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}