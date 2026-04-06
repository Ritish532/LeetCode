class Solution {
    public int fib(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2 ; i < n ; i++) arr[i] += (arr[i-1] + arr[i-2]);
        return arr[n-1];
    }
}

// class Solution {
//     public int[] dp;
//     public int fibbo(int n){
//         if(n <= 0) return 0;
//         if(n == 2 || n == 1) return 1;
//         if(dp[n] != 0) return dp[n];
//         return dp[n] = fibbo(n-1) + fibbo(n-2);
//     }
//     public int fib(int n) {
//         dp = new int[n+1];
//         return fibbo(n);
//     }
// }

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