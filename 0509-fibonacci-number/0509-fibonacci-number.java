class Solution {
    public int[] dp;
    public int fibbo(int n){
        if(n <= 0) return 0;
        if(n == 2 || n == 1) return 1;
        if(dp[n] != 0) return dp[n];
        int ans = fibbo(n-1) + fibbo(n-2);
        dp[n] = ans;
        return ans;
    }
    public int fib(int n) {
        dp = new int[n+1];
        return fibbo(n);
    }
}
// class Solution {
//     public int fibbo(int n){
//         if(n <= 0) return 0;
//         if(n == 2 || n == 1) return 1;
//         return fibbo(n-1) + fibbo(n-2);
//     }
//     public int fib(int n) {
//         return fibbo(n);
//     }
// }