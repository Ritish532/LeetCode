class Solution {
    public boolean dfs(char[][] board , int i , int j , String s , int k , boolean[][] vis){
        // if(i >= board.length && j >= board[0].length) return false;
        if(k == s.length()-1) return true;
        if(vis[i][j]) return vis[i][j];
        vis[i][j] = true;
        int n = board.length , m = board[0].length;
        if(i > 0 && !vis[i-1][j] && board[i-1][j] == s.charAt(k+1)){
            if(dfs(board , i-1 , j , s ,k+1 , vis)) return true;
        }
        if(j > 0 && !vis[i][j-1] && board[i][j-1] == s.charAt(k+1)){
            if(dfs(board , i , j-1 , s ,k+1 , vis)) return true;
        }
        if(i < n-1 && !vis[i+1][j] && board[i+1][j] == s.charAt(k+1)){
            if(dfs(board , i+1 , j , s ,k+1 , vis)) return true;
        }
        if(j < m-1 && !vis[i][j+1] && board[i][j+1] == s.charAt(k+1)){
            if(dfs(board , i , j+1 , s ,k+1 , vis)) return true;
        }
        vis[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length , m = board[0].length , p = word.length();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board , i , j , word , 0 , vis)) return true;
                }
            }
        }
        return false;
    }
}