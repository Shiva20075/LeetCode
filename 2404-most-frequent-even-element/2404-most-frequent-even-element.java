class Solution {
    public int mostFrequentEven(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0) {

                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
        }

        int max = 0;
        int ans = -1;

        for (int key : map.keySet()) {

            if (map.get(key) > max) {
                max = map.get(key);
                ans = key;
            } 
            else if (map.get(key) == max && key < ans) {
                ans = key;
            }
        }

        return ans;
    }
}