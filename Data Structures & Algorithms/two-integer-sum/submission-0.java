class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
