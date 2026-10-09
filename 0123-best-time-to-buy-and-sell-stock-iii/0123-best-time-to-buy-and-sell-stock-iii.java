class Solution {
    public int dfs(int i , int count , int canTake , int[] prices , int[][][] dp){
        if(i == prices.length || count == 2) return 0;
        if(dp[i][count][canTake] != -1) return dp[i][count][canTake];
        int take = 0;
        int skip = dfs(i+1 , count , canTake , prices , dp);
        if(canTake == 0) take = prices[i] + dfs(i+1 , count+1 , 1 , prices , dp);
        else take = -prices[i] + dfs(i+1 , count , 0 , prices , dp);
        return dp[i][count][canTake] = Math.max(take , skip);

    }
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][2];
        for(int[][] a : dp)
            for(int[] ele : a) Arrays.fill(ele , -1);
        return dfs(0 , 0 , 1 , prices , dp);
    }
}