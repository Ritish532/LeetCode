class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length , m = queries.length;
        int[] ans = new int[m];
        for(int i = 0 ; i < m ; i++){
            int left = queries[i][0] , right = queries[i][1];
            int xor = 0;
            for(int j = left ; j <= right ; j++){
                xor ^= arr[j];
            }
            ans[i] = xor;
        }
        return ans;
    }
}
// class Solution {
//     public int[] xorQueries(int[] arr, int[][] queries) {
//         int n = arr.length , m = queries.length;
//         for(int i = 1 ; i < n ; i++) arr[i] ^= arr[i-1];
//         int[] ans = new int[m];
//         for(int i = 0 ; i < m ; i++){
//             int a = queries[i][0] , b = queries[i][1];
//             if (a == 0) ans[i] = arr[b];
//             else ans[i] = arr[a-1] ^ arr[b];
//         }
//         return ans;
//     }
// }