class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        for(int i = 0 ; i < n ; i++){
            HashSet<Integer> set = new HashSet<>();
            HashSet<Integer> set1 = new HashSet<>();
            for(int j = 0 ; j < m ; j++){
                set.add(matrix[i][j]);
                set1.add(matrix[j][i]);
            }
            if(set.size() != m) return false;
            if(set1.size() != n) return false;
        }
        return true;
    }
}