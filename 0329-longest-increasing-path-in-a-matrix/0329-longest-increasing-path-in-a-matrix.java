class Solution {
    public int dfs(int i , int j , int c , int[][] matrix , boolean[][] vis , int[][] dp){
        int n = matrix.length , m = matrix[0].length;
        if(vis[i][j] || dp[i][j] != -1) return dp[i][j];
        vis[i][j] = true;
        int up = 0 , down = 0 , left = 0 , right = 0;
        if(i > 0   && !vis[i-1][j] && matrix[i][j] < matrix[i-1][j]) up =    dfs(i-1 , j , c+1 , matrix , vis , dp); 
        if(i < n-1 && !vis[i+1][j] && matrix[i][j] < matrix[i+1][j]) down =  dfs(i+1 , j , c+1 , matrix , vis , dp); 
        if(j > 0   && !vis[i][j-1] && matrix[i][j] < matrix[i][j-1]) left =  dfs(i , j-1 , c+1 , matrix , vis , dp); 
        if(j < m-1 && !vis[i][j+1] && matrix[i][j] < matrix[i][j+1]) right = dfs(i , j+1 , c+1 , matrix , vis , dp); 
        vis[i][j] = false;
        return dp[i][j] = 1 + Math.max(up , Math.max(down , Math.max(left , right)));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length , count = Integer.MIN_VALUE;
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row , -1);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                boolean[][] vis = new boolean[n][m];
                count = Math.max(count , dfs(i , j , 1 , matrix , vis , dp));
            }
        }
        return count;
    }
}