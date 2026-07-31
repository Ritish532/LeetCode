class Solution {
    public String longestPalindrome(String s) {
        int n = s.length() , p = 0 , q = 0;
        int[][] dp = new int[n][n];
        for(int k = 0 ; k < n ; k++){
            int i = 0 , j = k;
            while(j < n){   
                if(i == j) {      // for 1 length
                    dp[i][j] = 1;
                    p = i; q = j;
                }
                else if(j == i+1 && s.charAt(j) == s.charAt(i)){  // for 2 length
                    dp[i][j] = 1;
                    p = i; q = j;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){ // for > 2 length
                    dp[i][j] = 1;    
                    p = i; q = j;
                }
                else dp[i][j] = 0;
                i++;j++;
            }
        }
        return s.substring(p,q+1);
    }
}