class Solution {

    public int fromFront(int[] nums) {
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        if (minIndex > maxIndex) {
            return minIndex + 1;
        }

        return maxIndex + 1;
    }

    public int fromBack(int[] nums) {
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        if (minIndex < maxIndex) {
            return nums.length - minIndex;
        }

        return nums.length - maxIndex;
    }

    public int fromBothSides(int[] nums) {
        
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        if (minIndex < maxIndex) {
            return (minIndex + 1) + (nums.length - maxIndex);
        }

        return (maxIndex + 1) + (nums.length - minIndex);
    }

    public int minimumDeletions(int[] nums) {

        int first = fromFront(nums);
        int second = fromBack(nums);
        int third = fromBothSides(nums);

        if (first < second && first < third) {
            return first;
        }

        if (second < third) {
            return second;
        }

        return third;
    }
}
