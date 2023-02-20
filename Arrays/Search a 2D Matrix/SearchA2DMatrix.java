class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = (rows * cols) - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }
            if (target > matrix[mid / cols][mid % cols]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}