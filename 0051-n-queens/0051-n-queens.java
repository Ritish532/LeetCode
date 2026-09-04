class Solution {
    public List<List<String>> ans;

    public void Queens(int row , int n , char[][] chess){
        if(row == n){
            List<String> arr = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                String s = "";
                for(int j = 0; j < n ; j++){
                    s += chess[i][j];
                }
                arr.add(s);
            }
            ans.add(arr);
        }
        for(int col = 0 ; col < n ; col++){
            if(helper(row , col , chess)){
                chess[row][col] = 'Q';
                Queens(row+1 , n , chess);
                chess[row][col] = '.';
            }
        }
    }

    public boolean helper(int row , int col , char[][] chess){
        int i = row-1;
        while(i >= 0) if(chess[i--][col] == 'Q') return false; // upwards

        i = row-1;
        int j = col-1;
        while(i >= 0 && j >= 0) if(chess[i--][j--] == 'Q') return false; // left diagnol

        i = row-1;
        j = col+1;
        while(i >= 0 && j < chess.length) if(chess[i--][j++] == 'Q') return false; // right diagnol

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char[][] chess = new char[n][n];
        for(char[] row : chess) Arrays.fill(row , '.');
        Queens(0,n,chess);
        return ans;
    }
}