class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;        // Number of rows
        int n = matrix[0].length;     // Number of columns

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            // Prevent integer overflow during mid calculation
            int mid = low + (high - low) / 2;
            
            // Map 1D mid index to 2D matrix coordinates
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
