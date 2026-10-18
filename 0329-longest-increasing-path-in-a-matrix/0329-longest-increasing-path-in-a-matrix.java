class Solution {
    public int dfs(int i , int j , int c , int[][] matrix , int[][] dp){
        int n = matrix.length , m = matrix[0].length;
        if(dp[i][j] != -1) return dp[i][j];
        int up = 0 , down = 0 , left = 0 , right = 0;
        if(i > 0   &&  matrix[i][j] < matrix[i-1][j]) up =    dfs(i-1 , j , c+1 , matrix , dp); 
        if(i < n-1 &&  matrix[i][j] < matrix[i+1][j]) down =  dfs(i+1 , j , c+1 , matrix , dp); 
        if(j > 0   &&  matrix[i][j] < matrix[i][j-1]) left =  dfs(i , j-1 , c+1 , matrix , dp); 
        if(j < m-1 &&  matrix[i][j] < matrix[i][j+1]) right = dfs(i , j+1 , c+1 , matrix , dp); 
        return dp[i][j] = 1 + Math.max(up , Math.max(down , Math.max(left , right)));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length , count = Integer.MIN_VALUE;
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row , -1);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                count = Math.max(count , dfs(i , j , 1 , matrix , dp));
            }
        }
        return count;
    }
}
