class Solution {
    public int dfs(int i , int j , String s , String t , int[][] dp){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int take = 0;
        if(s.charAt(i) == t.charAt(j)) take = dfs(i+1 , j+1 , s , t , dp);
        int skip = dfs(i+1 , j , s , t , dp);
        return dp[i][j] = take + skip;
    }
    public int numDistinct(String s, String t) {
        int n = s.length() , m = t.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);
        return dfs(0 , 0, s , t , dp);
    }
}