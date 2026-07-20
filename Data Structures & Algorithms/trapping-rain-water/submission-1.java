class Solution {
    public int trap(int[] height) {
        int leftMaxSeen = 0, rightMaxSeen = 0, maxWaterCap = 0;
        int leftPointer = 0, rightPointer = height.length - 1;

        while (leftPointer < rightPointer) {
            if (height[leftPointer] <= height[rightPointer]) {
                if (height[leftPointer] < leftMaxSeen) {
                    maxWaterCap += leftMaxSeen - height[leftPointer];
                }
                leftMaxSeen = Math.max(leftMaxSeen, height[leftPointer]);
                leftPointer++;
            } else {
                if (height[rightPointer] < rightMaxSeen) {
                    maxWaterCap += rightMaxSeen - height[rightPointer];
                }
                rightMaxSeen = Math.max(rightMaxSeen,height[rightPointer]);
                rightPointer--;
            }
        }
        return  maxWaterCap;
    }
}
