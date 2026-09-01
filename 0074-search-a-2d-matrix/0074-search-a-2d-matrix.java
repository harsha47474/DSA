class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int high = m * n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % n;

            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
}