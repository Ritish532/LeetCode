class Solution {
    public String LCS(String a , String b){
        int n = a.length() , m = b.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1] ;
                else dp[i][j] =  Math.max( dp[i-1][j] , dp[i][j-1]);
            }
        }
        StringBuilder str = new StringBuilder("");
        int i = n , j = m;
        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)) {
                str.append(a.charAt(i-1));
                i--; j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])i--;
                 else j--;
        }
        str.reverse();
        return str.toString();
    }
    public String shortestCommonSupersequence(String a, String b) {
        String lcs = LCS(a , b);
        int i = 0 , j = 0 , k = 0;
        String ans = "";
        while( k < lcs.length()){
            while(a.charAt(i) != lcs.charAt(k)) ans += a.charAt(i++);
            while(b.charAt(j) != lcs.charAt(k)) ans += b.charAt(j++);
            ans += lcs.charAt(k++); i++; j++;
        }
        while(i<a.length()) ans += a.charAt(i++);
        while(j<b.length()) ans += b.charAt(j++);
        return ans;
    }
}