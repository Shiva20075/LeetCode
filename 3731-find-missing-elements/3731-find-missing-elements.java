import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        List<Integer> missing = new ArrayList<>();

        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            if (!list.contains(i)) {
                missing.add(i);
            }
        }

        return missing;
    }
}