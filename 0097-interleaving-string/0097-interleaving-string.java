class Solution {
    public boolean dfs(int i , int j , int k , int n , int m , int q , String s1, String s2, String s3 , Boolean[][] dp){
        if(k == q) return true;
        if(dp[i][j] != null) return dp[i][j];
        char ch = s3.charAt(k);
        if(i < n && ch == s1.charAt(i)){
            if(dfs(i+1 , j , k+1 , n , m , q , s1 , s2 , s3 , dp)) return dp[i][j] = true;
        }
        if(j < m && ch == s2.charAt(j)){
            if(dfs(i , j+1 , k+1 , n , m , q , s1 , s2 , s3 , dp)) return dp[i][j] = true;
        }
        return dp[i][j] = false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length() , m = s2.length() , q = s3.length();
        if(n+m != q) return false;
        Boolean[][] dp = new Boolean[n+1][m+1];
        return dfs(0 , 0 , 0 , n , m , q , s1 , s2 , s3 , dp);
    }
}