class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length , m = matrix[0].length;
        int low = 0;
        int high = n*m -1;
        int mid = low + (high - low)/2;
        while(low <= high){
            mid = low + (high - low)/2;
            int row = mid / m;
            int col = mid % m;
            if(target == matrix[row][col]) return true;
            else if(target > matrix[row][col]){
                low = mid+1;
            }
            else high = mid-1;
        }
        return false;
    }
}