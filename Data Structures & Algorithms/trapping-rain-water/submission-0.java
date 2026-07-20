class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMaxHeightSeen = new int[n];
        int[] rightMaxHeightSeen = new int[n];
        int maxHeightSeenTillNow = 0;
        
        for (int i = 1; i < n; i++) {
            maxHeightSeenTillNow = Math.max(maxHeightSeenTillNow, height[i - 1]);
            leftMaxHeightSeen[i] = maxHeightSeenTillNow;
        }
        
        maxHeightSeenTillNow = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxHeightSeenTillNow = Math.max(maxHeightSeenTillNow, height[i + 1]);
            rightMaxHeightSeen[i] = maxHeightSeenTillNow;
        }
        
        int maxWaterCapacity = 0;
        for (int i = 1; i < n; i++) {
            int minOfTheMaxHeightSeenEitherSide = Math.min(leftMaxHeightSeen[i], rightMaxHeightSeen[i]);
            maxWaterCapacity += ((height[i] < minOfTheMaxHeightSeenEitherSide) ? minOfTheMaxHeightSeenEitherSide - height[i] : 0);
        }
        
        return maxWaterCapacity;
    }
}
