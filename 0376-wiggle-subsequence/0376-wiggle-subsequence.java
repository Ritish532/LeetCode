class Solution {
    public int dfs(int i , int prev , int[] nums , int sign , int[][][] dp){
        if(i == nums.length) return 0;
        if(dp[i][prev][sign] != -1) return dp[i][prev][sign];
        int skip = dfs(i+1 , prev , nums , sign , dp);
        int take = 0;
        if(sign == 1){
            if(nums[prev] < nums[i]) take = 1 + dfs(i+1 , i , nums , 0 , dp);
        }
        else{
            if(nums[prev] > nums[i]) take = 1 + dfs(i+1 , i , nums , 1 , dp);
        }
        return dp[i][prev][sign] = Math.max(take , skip);
    }
    public int wiggleMaxLength(int[] nums) {
        // if(nums.length == 0) return 0;
        int[][][] dp = new int[nums.length][nums.length][2];
        for(int[][] ele : dp) for(int[] row : ele) Arrays.fill(row , -1);
        return 1 +  Math.max(dfs(1 , 0 , nums , 0 , dp) , dfs(1 , 0 , nums , 1 , dp));
    }
}
// 1 -> Positive
// 0 -> Negative