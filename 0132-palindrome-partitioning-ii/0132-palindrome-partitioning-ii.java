class Solution {
    public Boolean palindrome(int i , int j , String s , Boolean[][] paldp){
        if(i >= j) return true;
        if(paldp[i][j] != null) return paldp[i][j];
        if(s.charAt(i) != s.charAt(j)) return paldp[i][j] =  false;        
        return paldp[i][j] = palindrome(i+1 , j-1 , s , paldp);
    }
    public int dfs(int i , String a , String s , int[] dp , Boolean[][] paldp){
        int n = s.length();
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE;
        for(int j = i; j < n ; j++){
            if(paldp[i][j]){
                min = Math.min(min , 1 + dfs(j+1 , "" , s , dp , paldp));
            }
        }
        return dp[i] = min;
    }
    public int minCut(String s) {
        int dp[] = new int[s.length()];
        Boolean paldp[][]= new Boolean[s.length()][s.length()];
        Arrays.fill(dp , -1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                paldp[i][j] = palindrome(i, j, s, paldp);
        }
    }
        return dfs(0 , "" , s , dp , paldp) - 1;
    }
}