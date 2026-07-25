class Solution {
    public int digitFrequencyScore(int n) {

        Map<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        if (n == 0) {
            return 0;
        }

        while (n > 0) {

            int digit = n % 10;

            if (freq.containsKey(digit)) {
                freq.put(digit, freq.get(digit) + 1);
            } else {
                freq.put(digit, 1);
            }
            
            n = n / 10;
        }

        for (int key : freq.keySet()) {
            int temp = key * freq.get(key);
            ans += temp;
        }
        return ans;
    }
}