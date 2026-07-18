class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> seen = new HashSet<>();
        for (int curr: nums) {
            seen.add(curr);
        }

        int longestConsecutive = 1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int currConsecutive = 1;
            if (!seen.contains(curr - 1)) {
                while (seen.contains(curr + 1)) {
                    currConsecutive++;
                    curr++;
                }
                longestConsecutive = Math.max(longestConsecutive, currConsecutive);
            }
        }
        return longestConsecutive;
    }
}
