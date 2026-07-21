class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> combSum = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        findCombinations(candidates, target, 0, comb, combSum);
        return combSum;
    }

    public void findCombinations(int[] nums, int k, int index, List<Integer> combos, List<List<Integer>> combSum) {

        if (k == 0) {
            combSum.add(new ArrayList<>(combos));
            return;
        }

        if (index == nums.length) {
            return;
        }

        if (nums[index] <= k) {
            combos.add(nums[index]);
            findCombinations(nums, k - nums[index], index, combos, combSum);
            combos.remove(combos.size() - 1);
        }
        findCombinations(nums, k, index+1, combos, combSum);
    }
}