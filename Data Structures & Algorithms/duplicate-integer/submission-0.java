class Solution {
public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int curr : nums) {
            if (!set.add(curr)) {
                return true;
            }
        }
        return false;
    }
}