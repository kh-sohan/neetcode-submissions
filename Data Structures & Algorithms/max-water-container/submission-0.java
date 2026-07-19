class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxWater = 0;
        
        while (left < right) {
            int currentWaterCapacity = (right - left) * (Math.min(heights[left], heights[right]));
            maxWater = Math.max(currentWaterCapacity, maxWater);
            if (heights[left] <= heights[right]) {
                left++;
            } else right--;
        }
        
        return maxWater;
    }
}
