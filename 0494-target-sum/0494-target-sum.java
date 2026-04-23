class Solution {
    public int sum;
    public int find(int i , int s , int target , int[] nums , int[][] dp){
        if(i == nums.length){
            if(s == target) return 1;
            else return 0;
        }
        if(dp[i][s+sum] != -1) return dp[i][s+sum];
        int add = find(i+1 , s+nums[i] , target , nums , dp);
        int sub = find(i+1 , s-nums[i] , target , nums , dp);
        return dp[i][s+sum] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        sum = 0;
        for(int l : nums) sum += l;
        int[][] dp = new int[n][2*sum + 1];
        for(int[] row : dp) Arrays.fill(row , -1);
        return find(0 , 0 , target , nums , dp);
    }
}