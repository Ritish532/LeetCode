class Solution {
    public void dfs(int i , int j, int n , int m , int[][] grid , int oldColor , int color){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != oldColor) return;
        grid[i][j] = color;
        dfs(i+1 , j , n , m , grid , oldColor , color);
        dfs(i-1 , j , n , m , grid , oldColor , color);
        dfs(i , j+1 , n , m , grid , oldColor , color);
        dfs(i , j-1 , n , m , grid , oldColor , color);
        return;
    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int n = grid.length , m = grid[0].length , oldColor = grid[sr][sc];
        if (oldColor == color) return grid;
        dfs(sr , sc , n , m , grid , oldColor , color);
        return grid;
    }
}