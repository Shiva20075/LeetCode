class Solution {
    public int maximumGap(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int maxGap = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int gap = nums[i+1] - nums[i];

            if (gap > maxGap) {
                maxGap = gap;
            }
        }

        return maxGap;
    }
}