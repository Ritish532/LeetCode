class Solution {
    public int dfs(int i , int seenB , String s , int[][] dp){
        if(i == s.length()) return 0;
        if(dp[i][seenB] != -1) return dp[i][seenB];
        int del = 1 + dfs(i+1 , seenB , s , dp);
        int keep = Integer.MAX_VALUE;
        if(s.charAt(i) == 'b') keep = dfs(i+1 , 1 , s , dp);
        else if(seenB == 0) keep = dfs(i+1 , 0 , s , dp);
        return dp[i][seenB] = Math.min(del , keep);
    }
    public int minimumDeletions(String s) {
        int[][] dp = new int[s.length()][2];
        for(int[] row : dp) Arrays.fill(row , -1);
        return dfs(0 , 0 , s , dp);
    }
}