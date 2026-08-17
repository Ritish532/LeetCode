class Solution {
    public void dfs(int i , int j, int n , int m , char[][] grid){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '.') return ;
        grid[i][j] = '.';
        dfs(i+1 , j ,  n , m , grid);
        dfs(i-1 , j ,  n , m , grid);
        dfs(i , j+1 ,  n , m , grid);
        dfs(i , j-1 , n , m , grid);
    }
    public int countBattleships(char[][] grid) {
        int count = 0 , n = grid.length , m = grid[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 'X'){
                    dfs(i , j , n , m , grid);
                    count++;
                }
            }
        }
        return count;
    }
}