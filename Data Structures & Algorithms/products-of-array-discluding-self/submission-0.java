class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int currProduct = 1;
        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = currProduct * nums[i-1];
            currProduct = prefix[i];
        }

        currProduct = 1;
        suffix[nums.length-1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = currProduct * nums[i + 1];
            currProduct = suffix[i];
        }

        for (int i = 0; i < nums.length; i++) {
            prefix[i] = prefix[i] * suffix[i];
        }
        return prefix;
    }
}  
