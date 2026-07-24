class Solution {
// Pair class to hold the index from where the height started and the height itself
    private record Pair(int index, int height) {}

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        // Monotonic stack storing Pair(index, height)
        Deque<Pair> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            // Pop elements from stack while current height is smaller than top height
            while (!stack.isEmpty() && stack.peek().height() > heights[i]) {
                Pair top = stack.pop();
                int width = i - top.index();
                maxArea = Math.max(maxArea, top.height() * width);
                // Current bar can extend backward to where the popped bar started
                start = top.index();
            }

            // Push current bar with its modified start index
            stack.push(new Pair(start, heights[i]));
        }

        // Process any remaining bars in the stack
        int totalWidth = heights.length;
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            int width = totalWidth - top.index();
            maxArea = Math.max(maxArea, top.height() * width);
        }

        return maxArea;
    }
}
