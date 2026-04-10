class Solution {
    public boolean PerfectSq(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt*sqrt == n;
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            if(PerfectSq(i)) dp[i] = 1;
            else{
                int min = Integer.MAX_VALUE;
                for(int j = 1 ; j*j <= i ; j++){
                    int count = dp[j*j] + dp[i-(j*j)];
                    min = Math.min(count , min);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
// // Memoization
// class Solution {
//     public boolean PerfectSq(int n) {
//         int sqrt = (int) Math.sqrt(n);
//         return sqrt*sqrt == n;
//     }
//     public int Squares(int n , int[] dp) {
//         if(PerfectSq(n)) return 1;
//         if(dp[n] != -1) return dp[n];
//         int min = Integer.MAX_VALUE , count = 0;
//         for(int i = 1 ; i*i <= n ; i++){
//             count = (Squares(i*i,dp) + Squares(n-(i*i) , dp));
//             min = Math.min(count , min);
//         }
//         return dp[n] = min;
//     }

//     public int numSquares(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         return Squares(n,dp);
//     }
// }