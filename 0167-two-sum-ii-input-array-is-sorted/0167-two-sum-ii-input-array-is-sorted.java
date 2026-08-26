class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int needed = target - numbers[left];

            if (numbers[right] == needed) {
                int[] ans = new int[2];

                ans[0] = left + 1;
                ans[1] = right + 1;

                return ans;
            }
            else if (numbers[right] > needed) {
                right--;
            }
            else {
                left++;
            }
        }

        return new int[]{};
    }
}
