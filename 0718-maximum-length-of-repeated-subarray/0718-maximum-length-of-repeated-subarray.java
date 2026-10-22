class Solution {
    public int max;
    public int dfs(int[] nums1 , int[] nums2 , int i , int j , int[][] dp){
        if(i == nums1.length || j == nums2.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(nums1[i] == nums2[j]) {
            dp[i][j] = 1 + dfs(nums1 , nums2 , i+1 , j+1 , dp);
        }
        else{
            dp[i][j] = 0;
        }
        max = Math.max(max , dp[i][j]);
        return dp[i][j];
    }
    public int findLength(int[] nums1, int[] nums2) {
        max = Integer.MIN_VALUE;
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] row : dp) Arrays.fill(row , -1);
        for(int i = 0 ; i <  nums1.length ; i++)
            for(int j = 0 ; j < nums2.length ; j++) dfs(nums1 , nums2 , i , j , dp);
        return max;
    }
}