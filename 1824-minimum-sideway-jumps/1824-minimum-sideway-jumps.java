class Solution {
    public int dfs(int i , int lane , int[] obstacles , int[][] dp){
        if(i == obstacles.length-1) return 0;
        if(obstacles[i] == lane) return 1000000;
        if(dp[i][lane] != -1) return dp[i][lane];
        int min = 1000000;
        if(lane == obstacles[i+1]){
            for(int j = 1 ; j <= 3 ; j++){
                if(j != lane && obstacles[i] != j) min = Math.min(min , 1 + dfs(i , j , obstacles , dp));
            }
           return dp[i][lane] = min;
        }
        return dp[i][lane] = dfs(i+1 , lane , obstacles , dp);
    }
    public int minSideJumps(int[] obstacles) {
        int[][] dp = new int[obstacles.length][4];
        for(int[] row : dp) Arrays.fill(row , -1);
        return dfs(0 , 2 , obstacles , dp);
    }
}