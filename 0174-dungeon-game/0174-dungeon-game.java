class Solution {
    public int dfs(int i , int j , int n , int m , int[][] dungeon , int[][] dp){
        if(i == n-1 && j == m-1){
            return dp[i][j] = Math.max(1 , 1 - dungeon[i][j]);
        }
        if(dp[i][j] != -1) return dp[i][j];
        int right = Integer.MAX_VALUE , down = Integer.MAX_VALUE;
        if(i < n-1 ) down = dfs(i+1 , j , n , m , dungeon , dp);
        if(j < m-1 ) right = dfs(i , j+1 , n , m , dungeon , dp);
        int need = Math.min(right , down) - dungeon[i][j];
        return dp[i][j] = Math.max( 1 , need);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length , m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row , -1);
        return dfs(0 , 0 , n , m , dungeon , dp);
    }
}