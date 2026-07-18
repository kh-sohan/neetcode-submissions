class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; ++i) {
            if (i != 0 && nums[i - 1] == nums[i])
                continue;

            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    while ((left + 1 < right) && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (right - 1 > left && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else right--;
            }
        }
        return res;
    }
}
