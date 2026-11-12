class Solution {
    public int scoreOfString(String s) {

        int sum = 0;
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = (int) s.charAt(i);
        }

        for (int i = 1; i < arr.length; i++) {
            sum += Math.abs(arr[i] - arr[i - 1]);
        }

        return sum;
    }
}