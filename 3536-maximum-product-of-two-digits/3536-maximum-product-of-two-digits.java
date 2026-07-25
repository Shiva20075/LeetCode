class Solution {
    public int maxProduct(int n) {
        
        int[] digits = new int[10];
        int index = 0;

        while (n > 0) {
            digits[index++] = n % 10;
            n = n / 10;
        }
        Arrays.sort(digits);
        return digits[digits.length-1] * digits[digits.length-2];
    }
}