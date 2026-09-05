class Solution {
    public int Queens(int row , int n , char[][] chess){
        if(row == n) return 1;
        int x = 0;
        for(int col = 0 ; col < n ; col++){
            if(helper(row , col , n , chess)){
                chess[row][col] = 'Q';
                x += Queens(row+1 , n , chess);
                chess[row][col] = '.';
            }
        }
        return x;
    }

    public boolean helper(int row , int col , int n , char[][] chess){
        int i = row-1;
        while(i >= 0) if(chess[i--][col] == 'Q') return false;

        i = row - 1;
        int j = col - 1;
        while(i >= 0 && j >= 0) if(chess[i--][j--] == 'Q') return false;

        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < n) if(chess[i--][j++] == 'Q') return false;

        return true;
    }
    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        for(char[] row : chess) Arrays.fill(row , '.');
        return Queens(0, n , chess);
    }
}