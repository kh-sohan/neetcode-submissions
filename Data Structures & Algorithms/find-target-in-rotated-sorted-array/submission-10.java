class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low ) / 2;
            if (target == nums[mid])
                return mid;
            if (nums[mid] >= nums[low]) {        // left array is sorted
                if (target < nums[mid] && target >= nums[low]) {       // target is less than mid element and greater than first element
                    high = mid - 1;
                } else low = mid + 1;
            } else {                            // right array is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else high = mid - 1;
            }
        }
        return -1;
    }
}
