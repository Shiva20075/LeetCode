class Solution {
    public int trap(int[] height) {
        int[] leftMax = findLeftMax(height);
        int[] rightMax = findRightMax(height);
        int ans = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] < leftMax[i] && height[i] < rightMax[i]) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }

        return ans;
    }

    public int[] findLeftMax(int[] arr) {

        int[] leftMax = new int[arr.length];
        leftMax[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        return leftMax;
    }

    public int[] findRightMax(int[] arr) {

        int[] rightMax = new int[arr.length];
        rightMax[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        return rightMax;
    }
}