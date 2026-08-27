class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        findSubSets(nums, l, ans, 0);

        return ans;
    }

    public void findSubSets(int[] nums, List<Integer> l,List<List<Integer>> ans, int index) {

        if (index == nums.length) {
            if (!ans.contains(l)) {
                ans.add(new ArrayList<>(l));
            }
            return;
        }

        l.add(nums[index]);
        findSubSets(nums, l, ans, index + 1);
        l.remove(l.size() - 1);
        findSubSets(nums, l, ans, index + 1);
    }
}
