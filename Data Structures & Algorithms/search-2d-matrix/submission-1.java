class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean targetFound = false;
        int currRow = 0, currCol = matrix[0].length - 1;
        while (currRow < matrix.length && currCol >= 0) {
            int currNum = matrix[currRow][currCol];
            if (currNum == target) {
                targetFound = true;
                break;
            }
            if (currNum < target) {
                currRow++;
            } else currCol--;
        }
        return targetFound;
    }
}
