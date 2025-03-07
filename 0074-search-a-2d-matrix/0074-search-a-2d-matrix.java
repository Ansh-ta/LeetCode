class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while(row < rows && col > -1){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}