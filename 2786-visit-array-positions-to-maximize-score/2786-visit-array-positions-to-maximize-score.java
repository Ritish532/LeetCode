class Solution {
    public long Score(int i , int x, int[] nums , int p ,long[][] dp){
        if(i == nums.length) return 0;
        if(dp[i][p] != -1) return dp[i][p];
        int p2 = (nums[i] % 2 == 0)? 0 : 1;
        long take = nums[i] + Score(i+1 , x , nums , p2 , dp);
        if(p2 != p) take -= x;
        long skip = Score(i+1 , x, nums , p , dp);
        return dp[i][p] = Math.max(take , skip); 
    }
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        for(long[] row : dp) Arrays.fill(row,-1);
        int p = (nums[0] % 2 == 0)? 0 : 1;
        return nums[0] + Score(1,x,nums,p,dp);
    }
}