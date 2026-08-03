import java.util.*;

class Solution {

    public long subArrayRanges(int[] nums) {

        int[] NGE = findNGE(nums);
        int[] PGE = findPGE(nums);
        int[] NSE = findNSE(nums);
        int[] PSE = findPSE(nums);
        long minSum = 0;
        long maxSum = 0;

        for (int i = 0; i < nums.length; i++){

            long left = i - PSE[i];
            long right = NSE[i] - i;
            minSum += left*right *nums[i];

            long mleft = i - PGE[i];
            long mright = NGE[i] - i;
            maxSum += mleft*mright *nums[i];

        }
        return maxSum - minSum;
    }

    public int[] findNGE(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] NGE = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            NGE[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return NGE;
    }

    public int[] findPGE(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] PGE = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            PGE[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return PGE;
    }

    public int[] findPSE(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] PSE = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            PSE[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return PSE;
    }

    public int[] findNSE(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] NSE = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            NSE[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return NSE;
    }
}