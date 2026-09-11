class Solution {
    public boolean helper(int n , int m , int i , int j , Boolean[][] dp , String s , String p){
        if(j == m) return (i == n);
        if(dp[i][j] != null) return dp[i][j];
        boolean match = (i < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            return dp[i][j] = helper(n , m , i , j+2 , dp , s , p) || (match && helper(n , m , i+1 , j , dp , s , p));
        }
        return dp[i][j] = match && helper(n , m , i+1 , j+1 , dp , s , p);
    }
    public boolean isMatch(String s, String p) {
        int n = s.length() , m = p.length();
        Boolean[][] dp = new Boolean[n+1][m+1];
        return helper(n , m , 0 , 0 , dp , s , p);
    }
}