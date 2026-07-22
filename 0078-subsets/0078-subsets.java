class Solution {
    List<List<Integer>> r = new ArrayList<>();
    List<Integer> l = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0);
        return r;
    }

    public void solve(int[] nums, int index) {

        if (index == nums.length) {
            r.add(new ArrayList<>(l));
            return;
        }

        l.add(nums[index]);
        solve(nums, index + 1);
        l.remove(l.size() - 1);
        solve(nums, index + 1);
    }
}