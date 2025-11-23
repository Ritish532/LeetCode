class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int min_r = 0 , min_c = 0 , max_r = n-1 , max_c = n-1 , a = 1;
        while(max_c >= min_c && max_r >= min_r){
            for(int j = min_c ; j <= max_c ; j++){
                arr[min_r][j] = a;
                a++;
            }
            min_r++;
            for(int j = min_r ; j <= max_r ; j++){
                arr[j][max_c] = a;
                a++;
            }
            max_c--;
            for(int j = max_c ; j >= min_c; j--){
                arr[max_r][j] = a;
                a++;
            }
            max_r--;
            for(int j = max_r; j >= min_r ; j--){
                arr[j][min_c] = a;
                a++;
            }
            min_c++;

        }
        return arr;
    }
}