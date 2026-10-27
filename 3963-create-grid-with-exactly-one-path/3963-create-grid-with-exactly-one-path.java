class Solution {
    public String[] createGrid(int n, int m) {
        String[][] grid = new String[n][m];
        for(int j = 0 ; j < m ; j++) grid[0][j] = ".";
        for(int i = 0 ; i < n ; i++) grid[i][m-1] = ".";

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < m-1 ; j++) grid[i][j] = "#";
        }
        
        String[] ans = new String[n];
        for(int i = 0 ; i < n ; i++){
            String s  = "";
            for(int j = 0 ; j < m ; j++) s += grid[i][j];
            ans[i] = s;
        }
        return ans;
    }
}