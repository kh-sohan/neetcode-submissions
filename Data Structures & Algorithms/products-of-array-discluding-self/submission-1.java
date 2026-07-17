class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int currProduct = 1;
        for (int i = 1; i <= nums.length; i++) {
            prefix[i - 1] = currProduct;
            currProduct *= nums[i - 1];
        }

        currProduct = 1;
        for (int i = nums.length - 2; i >= -1; i--) {
            suffix[i + 1] = currProduct;
            currProduct *= nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            prefix[i] = prefix[i] * suffix[i];
        }
        return prefix;
    }
}  
