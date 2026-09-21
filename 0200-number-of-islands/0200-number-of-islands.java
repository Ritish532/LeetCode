class Solution {
    public class pair{
        int row;
        int col;
        pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    public void bfs(int i , int j, int n , int m , char[][] grid , boolean[][] vis){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i,j));
        vis[i][j] = true;
        while(q.size() > 0){
            pair a = q.remove();
            int r = a.row , c = a.col;
            if(r > 0 && grid[r-1][c] == '1' && !vis[r-1][c]){
                vis[r-1][c] = true;
                q.add(new pair(r-1 , c));
            } 
            if(c > 0 && grid[r][c-1] == '1' && !vis[r][c-1]){
                vis[r][c-1] = true;
                q.add(new pair(r , c-1));    
            }
            if(r < n-1 && grid[r+1][c] == '1' && !vis[r+1][c]){
                vis[r+1][c] = true;
                q.add(new pair(r+1 , c));
            }
            if(c < m-1 && grid[r][c+1] == '1' && !vis[r][c+1]){
                vis[r][c+1] = true;
                q.add(new pair(r , c+1));
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0 , n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    bfs(i , j , n , m , grid , vis);
                    count++;
                }
            }
        }
        return count;
    }
}