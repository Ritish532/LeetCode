// // BackTracking
// class Solution {
//     public int paths(int r , int c , int n , int m , boolean[][] visited){
//         if(r < 0 || c < 0 || r >= n || c >= m) return 0;
//         if(visited[r][c]) return 0;
//         if(r == n-1 && c == m-1) return 1;
//         visited[r][c] = true;
//         int right = paths(r , c+1 , n , m , visited);
//         int down = paths(r+1 , c , n , m , visited);
//         visited[r][c] = false;
//         return right + down;

//     }
//     public int uniquePaths(int n, int m) {
//         boolean visited[][] = new boolean[n][m];
//         return paths(0 , 0 , n , m , visited);
//     }
// }


// Tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++) 
            for(int j = 0 ; j < n ;j++) 
                if(i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
        return dp[m-1][n-1];
    }
}

// //Memoization
// class Solution {
//     public int Paths(int row , int col , Integer m, Integer n , int[][] dp) {
//         if(row >= m || col >= n) return 0;
//         if(row == m-1 && col == n-1) return 1;
//         if(dp[row][col] != -1) return dp[row][col];
//         return dp[row][col] = Paths(row+1 , col , m , n , dp) + Paths(row , col+1 , m , n , dp);
//     }
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for(int i = 0 ; i < m ; i++) for(int j = 0 ; j < n ;j++) dp[i][j] = -1;
//         return Paths(0 , 0 , m , n , dp);
//     }
// }