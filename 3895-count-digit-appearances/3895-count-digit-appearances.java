class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            while (num > 0) {
                int lastDigit = num % 10;

                if (lastDigit == digit) {
                    count++;
                }

                num = num / 10;
            }
        }

        return count;
    }
}