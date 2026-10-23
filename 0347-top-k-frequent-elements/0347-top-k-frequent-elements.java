class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> freq = new HashMap<>();
        int[] ans = new int[k];

        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i],freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i],1);
            }
        }

        List<Map.Entry<Integer,Integer>> l = new ArrayList<>(freq.entrySet());
        l.sort((a,b) -> Integer.compare(b.getValue(),a.getValue()));

        for (int i = 0; i < k; i++) {
            ans[i] = l.get(i).getKey();
        }

        return ans;
    }
}