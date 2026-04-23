class Solution {
    public int Sum(int i , int target , List<Integer> nums, int[][] dp){
        if(target == 0) return 0;
        if(i == nums.size()) return Integer.MIN_VALUE;
        if(dp[i][target] != -1) return dp[i][target];
        int skip = Sum(i+1 , target , nums , dp);
        int take = Integer.MIN_VALUE; 
        if(target >= nums.get(i)){
            int res = Sum(i+1 , target- nums.get(i) , nums , dp);
            if(res != Integer.MIN_VALUE) take = 1 + res;
        }
        return dp[i][target] = Math.max(skip , take);

    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        int ans = (Sum(0 , target , nums , dp));
        return (ans < 0)? -1 : ans;
    }
}