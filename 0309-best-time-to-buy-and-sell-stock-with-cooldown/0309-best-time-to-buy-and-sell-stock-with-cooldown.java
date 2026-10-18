class Solution {
    public int dfs(int[] prices , int i , int buy , int[][] dp){
        if(i >= prices.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        int take = 0 , skip = 0 , l = 0;
        if(buy == 1){
            take = -prices[i] + dfs(prices , i+1 , 0 , dp);
            skip = dfs(prices , i+1 , 1 , dp);
        }
        else{
            take = prices[i] + dfs(prices , i+2 , 1 , dp);
            skip = dfs(prices , i+1 , 0 , dp);
        }
        return dp[i][buy] = Math.max(take , skip);
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp) Arrays.fill(row , -1);
        return dfs(prices , 0 , 1 , dp);
    }
}
 // 1 -> Buy
 // 0 -> Sell