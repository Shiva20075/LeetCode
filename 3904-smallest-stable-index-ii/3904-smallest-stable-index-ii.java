class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int idx = -1;
        int max = Integer.MIN_VALUE;
        int min[] = new int [nums.length];
        min[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < n; i++) {
           min[nums.length - i - 1] = Math.min(min[nums.length - i],nums[nums.length - 1 - i]);

        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);

            if (max - min[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}