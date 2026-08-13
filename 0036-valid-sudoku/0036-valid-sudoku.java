class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i = 0 ; i < n ; i++){
            HashSet<Integer> set = new HashSet<>();
            HashSet<Integer> set1 = new HashSet<>();
            for(int j = 0 ; j < n ; j++){
                int a = board[i][j];
                if(a != 46){
                    if(set.contains(a)) return false;
                    set.add(a);
                }
                int b = board[j][i];
                if(b != 46){
                    if(set1.contains(b)) return false;
                    set1.add(b);
                }
            }
        }
        for(int r = 0 ; r < n ; r+=3){
           for(int c = 0 ; c < n ;c+=3){
            
            HashSet<Integer> set = new HashSet<>();
            for(int i = r ; i < r+3 ; i++){
                for(int j = c ; j < c+3 ; j++){
                    int a = board[i][j];
                    if(a != 46){
                        if(set.contains(a)) return false;
                        set.add(a);
                    }
                }       
            }
        }
    }
    return true;
}   
}