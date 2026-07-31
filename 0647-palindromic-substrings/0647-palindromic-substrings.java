class Solution {
    public int countSubstrings(String s) {
        int n = s.length() , count = 0;
        int[][] dp = new int[n][n];
        for(int k = 0 ; k < n ; k++){
            int i = 0 , j = k;
            while(j < n){
                if(i == j) {
                    dp[i][j] = 1;
                    count++;
                }
                else if(j == i+1 && s.charAt(j) == s.charAt(i)){
                    dp[i][j] = 1;
                    count++;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                    count++;
                }
                else dp[i][j] = 0;
                i++;j++;
            }
        }
        return count;
    }
}