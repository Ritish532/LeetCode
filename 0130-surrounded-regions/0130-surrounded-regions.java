class Solution {
    public boolean flag;
    public void dfs(char[][] board , int i , int j , int n , int m , boolean[][] vis , List<int[]> list){
        if(i < 0 || j < 0 || j >= m || i >= n) return;
        if(board[i][j] == 'X' || vis[i][j]) return;
        vis[i][j] = true;
        list.add(new int[]{i,j});
        if(i == 0 || i == n-1 || j == 0 || j == m-1){
            flag = true;
            return;
        }
        dfs(board , i+1 , j , n , m , vis , list);
        dfs(board , i , j+1 , n , m , vis , list);
        dfs(board , i-1 , j , n , m , vis , list);
        dfs(board , i , j-1 , n , m , vis , list);
    }
    public void solve(char[][] board) {
        flag = false;
        int n = board.length , m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 1 ; i < n-1 ; i++){
            for(int j = 1 ; j < m-1 ; j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    List<int[]> list = new ArrayList<>();
                    flag = false;
                    dfs(board , i , j , n , m , vis , list);
                    if(!flag){
                        for(int[] ele : list){
                            int a = ele[0] , b = ele[1];
                            board[a][b] = 'X';
                        }
                    }
                }
            }
        }
    }
}