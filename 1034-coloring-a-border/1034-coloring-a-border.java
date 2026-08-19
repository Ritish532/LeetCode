class Solution {
    public void dfs(int i , int j , int n , int m , int color , int oldColor , int[][] grid){
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] != oldColor || grid[i][j] == 0) return;
        grid[i][j] = -1;
        dfs(i+1 , j , n , m , color , oldColor , grid);
        dfs(i-1 , j , n , m , color , oldColor , grid);
        dfs(i , j+1 , n , m , color , oldColor , grid);
        dfs(i , j-1 , n , m , color , oldColor , grid);
         
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length , m = grid[0].length , oldColor = grid[row][col];
        if (oldColor == color) return grid;
        dfs(row , col , n , m , color , oldColor , grid);
        boolean[][] flag = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] != -1) continue;
                if(i == 0 || j == 0 || j == m-1 || i == n-1) {
                    flag[i][j] = true;
                    continue;
                }
                if(grid[i - 1][j] != -1 ||
                    grid[i + 1][j] != -1 ||
                    grid[i][j - 1] != -1 ||
                    grid[i][j + 1] != -1){
                        flag[i][j] = true;
                        continue;
                    }

            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j< m ; j++){
                if(grid[i][j] == -1){
                    if(flag[i][j]) grid[i][j] = color;
                    else grid[i][j] = oldColor;
                }
            }
        }
        return grid;
    }
}