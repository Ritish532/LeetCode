class Solution {
    public boolean check = false;
    public void solve(int row , int col , char[][] board){
        if(row == 9){
            check = true;
            return;
        }
        if(board[row][col] != 46){
            if(col == 8) solve(row+1 , 0 , board);
            else solve(row , col+1 , board);
        }
        else {
            for(char i = '1' ; i <= '9' ; i++){
                if(isValid(row , col , board , i)){
                    board[row][col] = i;
                    if(col == 8) solve(row+1 , 0 , board);
                    else solve(row , col+1 , board);
                    if(!check) board[row][col] = '.';
                }
            }
        }
    }

    public boolean isValid(int row , int col , char[][] board , char ch){
        for(int i = 0 ; i < 9 ; i++) if(board[i][col] == ch || board[row][i] == ch) return false;
        int srow = (row / 3) * 3;
        int scol = (col / 3) * 3;
        for(int k = srow ; k < srow + 3 ; k++){
            for(int l = scol ; l < scol + 3 ; l++){
                if(board[k][l] == ch) return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(0 , 0 , board);
    }
}